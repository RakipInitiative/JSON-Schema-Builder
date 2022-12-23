package de.bund.bfr.kidaeditorbackend.controller;

import de.bund.bfr.kidaeditorbackend.model.JsonSchema;
import de.bund.bfr.kidaeditorbackend.model.ModelBody;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kidaBackend")
public class EditorController {

    ModelBody modelBody;
    public EditorController() {
    }

    @GetMapping("/responseModel")
    public @ResponseBody ModelBody getOneModel() {
        this.modelBody = new ModelBody("1", "SampleModel");
        return modelBody;
    }

    @RequestMapping(value = "/responseModel/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public @ResponseBody String getSchema(@RequestBody String id) {

        return JsonSchema.schema;
    }
}
