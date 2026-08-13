package com.tss.__jpa_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "employee")
public class Employee {
    @Column(name = "employee_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "department")
    private String department;

    @Column(name = "image_url")
    private String imageUrl;
}
