package com.tss.__jpa_app.repository;

import com.tss.__jpa_app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    //List<Student> deleteByAge(Integer age);

    Integer deleteByAge(Integer age);
}
