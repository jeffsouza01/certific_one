package com.porto.certific_one.modules.questions.controllers;

import com.porto.certific_one.modules.questions.dtos.AlternativesResultDTO;
import com.porto.certific_one.modules.questions.dtos.QuestionAlternativesDTO;
import com.porto.certific_one.modules.questions.entities.Alternatives;
import com.porto.certific_one.modules.questions.entities.Questions;
import com.porto.certific_one.modules.questions.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;


    @GetMapping("/technology/{technology}")
    public  List<QuestionAlternativesDTO> getAllQuestionsByTechnology(@PathVariable String technology){
        var result = questionRepository.findByTechnology(technology);

        var mapResult = result.stream().map(question -> mapQuestioToDTO(question))
                .collect(Collectors.toList());

        return mapResult;
    }

    static QuestionAlternativesDTO mapQuestioToDTO(Questions questions) {
        var questioResultDTO = new QuestionAlternativesDTO(
                questions.getId(),
                questions.getDescription(),
                questions.getTechnology(),
                questions.getAlternatives().stream().map(alternative -> mapAlternativeDTO(alternative))
                        .collect(Collectors.toList())
        );

        return questioResultDTO;

    }

    static AlternativesResultDTO mapAlternativeDTO(Alternatives alternatives){
        return new AlternativesResultDTO(alternatives.getId() , alternatives.getDescription());

    }
}
