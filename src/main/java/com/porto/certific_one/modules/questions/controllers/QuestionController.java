package com.porto.certific_one.modules.questions.controllers;

import com.porto.certific_one.modules.questions.entities.Questions;
import com.porto.certific_one.modules.questions.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;


    @GetMapping("/technology/{technology}")
    public  List<Questions> getAllQuestionsByTechnology(@PathVariable String technology){
        return questionRepository.findByTechnology(technology);
    }
}
