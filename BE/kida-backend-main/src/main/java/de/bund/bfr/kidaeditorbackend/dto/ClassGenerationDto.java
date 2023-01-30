package de.bund.bfr.kidaeditorbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class ClassGenerationDto {
    private String id;
    private String language;
}
