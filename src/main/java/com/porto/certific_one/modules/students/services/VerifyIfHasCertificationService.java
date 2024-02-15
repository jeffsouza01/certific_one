package com.porto.certific_one.modules.students.services;

import com.porto.certific_one.modules.students.dto.VerifyCertificationDTO;
import com.porto.certific_one.modules.students.repositories.CertificationStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyIfHasCertificationService {


    @Autowired
    private CertificationStudentRepository certificationStudentRepository;

    public boolean execute(VerifyCertificationDTO dto) {
        var certificate = this.certificationStudentRepository.findByCertificationStudentEmailAndTechnology((dto.email()), dto.certification());

        if (!certificate.isEmpty()) {
           return true;
       }
        return false;
    }
}
