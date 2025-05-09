package com.university.result_management.models;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;

    private String code;

    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private int semester;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

	
    
}
