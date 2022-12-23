"use strict";

var myApp = angular.module("schema-builder", ["ui.bootstrap", "json-schema"]);

myApp.controller("schemaCtrler", schemaCtrler);
myApp.controller("redirectCtrler", redirectCtrler);
myApp.controller("addNewModelCtrl", addNewModelCtrl);
myApp.controller("addNewModelContent", addNewModelContent);
myApp.controller("saveModelCtrl", saveModelCtrl);
myApp.controller("saveModelContent", saveModelContent);
myApp.controller("dataSavedModelContent", dataSavedModelContent);
myApp.controller("redirectToHomeCtrl", redirectToHomeCtrl);

schemaCtrler.$inject = ["$scope", "JsonSchema"];

const backendUrl = "http://ec2-3-122-241-128.eu-central-1.compute.amazonaws.com:8080";

function getCurrentSchemeId() {
  var queryString = window.location.search;
  var urlParams = new URLSearchParams(queryString);
  return urlParams.get("id");
}

async function redirectToHomeCtrl($scope, $window) {
  $scope.toHome = function () {
    $window.open("index.html", "_self");
  };
}

async function download(currentSchemeId, fileName) {
  var downloadFile = function (dataToWrite) {
    var dataStingify = JSON.stringify(dataToWrite);

    var blob = new Blob([dataStingify], { type: "application/json" });
    var href = URL.createObjectURL(blob);

    var a = Object.assign(document.createElement("a"), {
      href,
      style: "display:none",
      download: `${fileName}.json`,
    });

    document.body.appendChild(a);

    a.click();
    URL.revokeObjectURL(href);
    a.remove();
  };

  try {
    const response = await fetch(
      backendUrl + "/kidaBackend/download",
      {
        method: "POST",
        headers: {
          accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          id: `${currentSchemeId}`,
        }),
      }
    );
    var data = await response.json();
    downloadFile(await data);
    return data;
  } catch (error) {
    console.log("Error downloading the file : ", error);
  }
}

async function getAllData() {
  try {
    const response = await fetch(
      backendUrl + "/kidaBackend/allModels",
      {
        method: "GET",
        mode: "cors",
        headers: {
          accept: "application/json",
        },
      }
    );
    var data = await response.json();
    return data;
  } catch (error) {
    console.log("Error in loading all models : ", error);
    alert("Error in loading all models");
  }
}

async function addSchema(name, fileName, url, accessToken) {
  try {
    const response = fetch(
      backendUrl + "/kidaBackend/addSchema",
      {
        method: "POST",
        headers: {
          accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          name: name,
          fileName: fileName,
          url: url,
          accessToken: accessToken,
        }),
      }
    );
    return (await response).status;
  } catch (error) {
    console.log(
      `Error in loading the model with id ${currentSchemeId} : `,
      error
    );
  }
}

async function getModel(currentSchemeId) {
  try {
    const response = fetch(
      backendUrl + "/kidaBackend/getModel",
      {
        method: "POST",
        headers: {
          accept: "application/json",
          "Content-Type": "application/json",
        },

        body: JSON.stringify({
          id: `${currentSchemeId}`,
        }),
      }
    );
    var data = await response;
    return data;
  } catch (error) {
    console.log(
      `Error in loading the model with id ${currentSchemeId} : `,
      error
    );
  }
}

async function saveModel(newSchema, def, accessToken) {
  var apiResponse = await getModel(getCurrentSchemeId());
  var oldSchema = await apiResponse.json();

  var finalSchema = {
    $defs: def,
    $id: oldSchema.$id,
    $schema: oldSchema.$schema,
    title: oldSchema.$schema,
    ...newSchema,
  };

  var string = JSON.stringify(finalSchema);
  var encodedString = btoa(unescape(encodeURIComponent(string)));

  try {
    const response = fetch(
      backendUrl + "/kidaBackend/saveModel",
      {
        method: "PUT",
        headers: {
          accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          id: oldSchema.$id,
          updatedSchema: encodedString,
          accessToken: accessToken,
        }),
      }
    );

    return (await response).status;
  } catch (err) {
    console.log(`Error in saving model with id ${currentSchemeId} : `, error);
  }
}

async function schemaCtrler($scope, JsonSchema) {
  $scope.statusCode = "000";

  var currentSchemeId = getCurrentSchemeId();

  var response = await getModel(currentSchemeId);
  var schemaToEdit = await response.json();

  $scope.def = schemaToEdit.$defs;

  $scope.data = JsonSchema.schema2obj(schemaToEdit);
  $scope.data.root$$ = true;
  $scope.$applyAsync();

  $scope.childs = {};
  for (var prop in $scope.def) {
    $scope.childs[prop] = {};
    $scope.childs[prop] = JsonSchema.schema2obj($scope.def[prop]);
    $scope.childs[prop].root$$ = true;
    $scope.childs[prop].defName = prop;
    $scope.$applyAsync();
  }
}

async function redirectCtrler($scope, $window) {
  $scope.data = await getAllData();
  $scope.$applyAsync();

  $scope.download = async function (id, fileName) {
    await download(id, fileName);
  };

  $scope.changeValue = function (param) {
    $window.open(`editor.html?id=${param}`, "_self");
  };
}

async function addNewModelCtrl($scope, $uibModal) {
  $scope.open = function () {
    var modalInstance = $uibModal.open({
      templateUrl: "addNewModelContent.html",
      controller: "addNewModelContent",
      size: "",
    });
    modalInstance.result.then(async function (response) {
      let name = response.name;
      let fileName = response.fileName;
      let url = response.url;
      let accessToken = response.accessToken;

      const status = await addSchema(name, fileName, url, accessToken);

      if ((status === 200) | (status === 204)) {
        $scope.message = "Data added successfully";
      } else {
        $scope.message = "Unable to add data successfully";
      }

      $uibModal.open({
        templateUrl: "dataSavedModelContent.html",
        controller: "dataSavedModelContent",
        size: "",
        scope: $scope,
      });
    });
  };
}

async function addNewModelContent($scope, $uibModalInstance) {
  $scope.getData = function (data) {
    $uibModalInstance.close(data);
  };

  $scope.cancel = function () {
    $uibModalInstance.dismiss();
  };
}

async function saveModelCtrl($scope, JsonSchema, $uibModal) {
  $scope.toHome = function () {
    window.open("index.html", "_self");
  };

  $scope.open = function (data, childs) {
    var schemaToSave = JsonSchema.obj2schema(data);

    var keys = Object.keys(childs);

    var $def = {};

    for (var key in keys) {
      $def = {
        ...$def,
        [keys[key]]: JsonSchema.obj2schema(childs[keys[key]]),
      };
    }

    var modalInstance = $uibModal.open({
      templateUrl: "saveModelContent.html",
      controller: "saveModelContent",
      scope: $scope,
      size: "",
    });

    modalInstance.result.then(async function (response) {
      let accessToken = await response.accessToken;
      let statusCode = await saveModel(schemaToSave, $def, accessToken);

      $scope.statusCode = await statusCode;

      if (statusCode === 200 || statusCode === 204) {
        $scope.message = "Data saved properly";
        $uibModal.open({
          templateUrl: "dataSavedModelContent.html",
          controller: "dataSavedModelContent",
          scope: $scope,
        });
      } else {
        $scope.message = "Error in saving data";
        $uibModal.open({
          templateUrl: "dataSavedModelContent.html",
          controller: "dataSavedModelContent",
          scope: $scope,
        });
      }
    });
  };
}

async function saveModelContent($scope, $uibModalInstance) {
  $scope.saveModel = function (data) {
    $uibModalInstance.close(data);
  };

  $scope.cancel = function () {
    $uibModalInstance.dismiss();
  };
}

async function dataSavedModelContent($scope, $uibModalInstance) {
  $scope.ok = function () {
    $uibModalInstance.dismiss();
    if (($scope.statusCode === 200) | ($scope.statusCode === 204)) {
      location.reload();
    }
  };
}
