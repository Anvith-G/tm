package com.university.result_management.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int semester;

    private Double GPA;

    private String remarks;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
