package com.tss.__jpa_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "course")
public class Course {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    @Column
    private String courseName;
    @Column
    private Integer duration;
    @Column
    private Double fees;
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean isActive=true;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;


    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private List<Student> students;

}
