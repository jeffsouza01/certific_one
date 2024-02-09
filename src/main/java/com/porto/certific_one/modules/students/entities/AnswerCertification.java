package com.porto.certific_one.modules.students.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_answer_certification")
public class AnswerCertification {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "certification_id")
    private UUID certificationID;


    @ManyToOne
    @JoinColumn(name = "certification_id",  insertable = false, updatable = false)
    private CertificationStudent certificationStudent;

    @Column(name = "student_id")
    private UUID studentID;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @JoinColumn(name = "question_id")
    private UUID questionID;

    @JoinColumn(name = "answer_id")
    private UUID answerID;

    private Boolean isCorrect;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
