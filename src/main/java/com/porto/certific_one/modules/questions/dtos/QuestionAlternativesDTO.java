package com.porto.certific_one.modules.questions.dtos;

import java.util.List;
import java.util.UUID;

public record QuestionAlternativesDTO(
        UUID id,
        String technology,
        String description,
        List<AlternativesResultDTO> alternatives
        ) {
}
