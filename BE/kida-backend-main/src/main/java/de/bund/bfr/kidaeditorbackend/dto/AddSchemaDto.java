package de.bund.bfr.kidaeditorbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
@Data
public class AddSchemaDto {
    private String name;
    private String fileName;
    private String url;
    private String accessToken;
}
