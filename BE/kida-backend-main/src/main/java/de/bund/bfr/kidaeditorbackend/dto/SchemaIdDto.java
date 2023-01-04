package de.bund.bfr.kidaeditorbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * A DTO class for the schema ID. Required because the ID contains slash-character and
 * therefore cannot be used in a path variable
 */
@NoArgsConstructor
@SuperBuilder
@Data
public class SchemaIdDto {
    private String id;
}
