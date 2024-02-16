package com.porto.certific_one.modules.questions.repositories;

import com.porto.certific_one.modules.questions.entities.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, UUID> {

    List<Questions> findByTechnology(String technology);
}
