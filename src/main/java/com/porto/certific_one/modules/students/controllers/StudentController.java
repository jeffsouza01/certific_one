package com.porto.certific_one.modules.students.controllers;

import com.porto.certific_one.modules.students.dto.VerifyCertificationDTO;
import com.porto.certific_one.modules.students.services.VerifyIfHasCertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private VerifyIfHasCertificationService verifyIfHasCertificationService;


    @PostMapping("/verifyCertification")
    public String verifyIfHasCertification(@RequestBody VerifyCertificationDTO verifyCertificationDTO) {

        System.out.println(verifyCertificationDTO);
        return "Poderá realizar a certificação";
    }
}
