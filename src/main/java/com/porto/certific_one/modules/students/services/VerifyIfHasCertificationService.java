package com.porto.certific_one.modules.students.services;

import org.springframework.stereotype.Service;

@Service
public class VerifyIfHasCertificationService {

    public boolean execute(Object obj) {
        return super.equals(obj);
    }
}
