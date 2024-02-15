package com.porto.certific_one.modules.students.repositories;

import com.porto.certific_one.modules.students.entities.CertificationStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CertificationStudentRepository extends JpaRepository<CertificationStudent, UUID> {

    @Query("SELECT c FROM tb_certification c INNER JOIN c.student std WHERE std.email = :email AND c.technology = :technology")
    List<CertificationStudent> findByCertificationStudentEmailAndTechnology(String email, String technology);
}
