package de.bund.bfr.kidaeditorbackend.model;

import lombok.Data;

@Data
public class ModelBody {

    private String id;
    private String name;

    public ModelBody(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public ModelBody() {
    }
}
