package com.tss.__jpa_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "instructor")
public class Instructor {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructorId;
    @Column
    private String instructorName;
    @Column
    private String designation;
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean isActive=true;

    @OneToMany(mappedBy = "instructor",cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH})
    private List<Course> courses;
}
