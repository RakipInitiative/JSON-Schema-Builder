package de.bund.bfr.kidaeditorbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OpenApiService {

    private static final String COMPONENT_SCHEMAS_BASE = "#/components/schemas/";
    private static final int SPEC_INDENT_FACTOR = 4;

    public String getOpenApiSpecFromJson(JSONObject schema) {
        JSONObject openApiSpec = createBasicOpenApiSpec(schema);
        addDefintionsToSpec(openApiSpec, schema);
        addModelParentClassToSpec(openApiSpec, schema);

        // Replace all reliant on #/$defs/ not being somewhere else other than $ref objects
        return openApiSpec.toString(SPEC_INDENT_FACTOR).replaceAll("#/[$]defs/", COMPONENT_SCHEMAS_BASE);
    }

    private JSONObject createBasicOpenApiSpec(JSONObject schema) {
        JSONObject openApiBase = new JSONObject();
        openApiBase.put("openapi", "3.0.0");

        JSONObject info = new JSONObject();
        info.put("version", "1.0.0");
        info.put("title", schema.getString("title"));

        openApiBase.put("paths", new JSONObject());
        JSONObject schemas = new JSONObject();
        JSONObject components = new JSONObject().put("schemas", schemas);
        openApiBase.put("components", components);
        return openApiBase;
    }


    private void addDefintionsToSpec(JSONObject openApiSpec, JSONObject schema) {

        if (!schema.has("$defs")) {
            return;
        }

        JSONObject defs = schema.getJSONObject("$defs");
        JSONObject specSchemas = openApiSpec.getJSONObject("components")
                .getJSONObject("schemas");
        for (String key : defs.keySet()) {
            specSchemas.put(key, defs.getJSONObject(key));
        }
    }


    private void addModelParentClassToSpec(JSONObject openApiSpec, JSONObject schema) {

        if (!schema.has("properties")) {
            return;
        }

        JSONObject schemas = schema.getJSONObject("properties");
        String type = schema.getString("type");
        JSONObject mainModel = new JSONObject();
        mainModel.put("type", type);
        mainModel.put("properties", schemas);
        JSONObject specSchemas = openApiSpec.getJSONObject("components")
                .getJSONObject("schemas");
        specSchemas.put("mainModel", mainModel);
    }

}
