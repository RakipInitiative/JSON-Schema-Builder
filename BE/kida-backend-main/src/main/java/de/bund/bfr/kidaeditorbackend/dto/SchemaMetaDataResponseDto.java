package de.bund.bfr.kidaeditorbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Collection;

/**
 * A DTO class containing meta data for a model schema
 */
@SuperBuilder
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SchemaMetaDataResponseDto {
    private String id;
    private String name;
    private String url;
    private Collection<String> versions;
    private String fileName;
}
