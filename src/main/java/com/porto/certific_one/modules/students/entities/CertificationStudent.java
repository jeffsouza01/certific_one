package com.porto.certific_one.modules.students.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_certification")
public class CertificationStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String technology;
    private Integer grate;

    @JoinColumn(name = "student_id")
    private UUID studentID;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @OneToMany
    @JoinColumn(name = "answer_certification_id", insertable = false, updatable = false)
    private List<AnswerCertification> answerCertifications;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
