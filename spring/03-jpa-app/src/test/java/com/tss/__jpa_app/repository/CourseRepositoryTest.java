package com.tss.__jpa_app.repository;

import com.tss.__jpa_app.dto.CoursesCountDto;
import com.tss.__jpa_app.entity.Course;
import com.tss.__jpa_app.entity.Instructor;
import com.tss.__jpa_app.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private InstructorRepository instructorRepository;

    @Test
    void countCoursesByInstructorId() {

        Instructor instructor = new Instructor();
        instructor.setInstructorName("Prince");
        instructor.setDesignation("Software engineer");
        instructor.setIsActive(true);

        Instructor result= instructorRepository.save(instructor);

        Course course = new Course();
        course.setCourseName("Spring Boot");
        course.setDuration(6);
        course.setFees(15000.0);
        course.setIsActive(true);
        course.setInstructor(instructor);

        courseRepository.save(course);

        Long count= courseRepository.countCoursesByInstructorId(result.getInstructorId());

        assertEquals(1,count);
    }

    @Test
    void getCourseCounts() {
        Instructor instructor1 = new Instructor();
        instructor1.setInstructorName("Prince");
        instructor1.setDesignation("Software engineer");
        instructor1.setIsActive(true);

        instructorRepository.save(instructor1);

        Instructor instructor2 = new Instructor();
        instructor2.setInstructorName("Hardik");
        instructor2.setDesignation("Software engineer");
        instructor2.setIsActive(true);

        instructorRepository.save(instructor2);

        Course course1 = new Course();
        course1.setCourseName("Spring Boot");
        course1.setDuration(6);
        course1.setFees(15000.0);
        course1.setIsActive(true);
        course1.setInstructor(instructor1);

        courseRepository.save(course1);

        Course course2 = new Course();
        course2.setCourseName("Spring Boot");
        course2.setDuration(6);
        course2.setFees(15000.0);
        course2.setIsActive(true);
        course2.setInstructor(instructor2);

        courseRepository.save(course2);

        List<CoursesCountDto> result = courseRepository.getCourseCounts();

        assertNotNull(result);
        assertEquals(2, result.size());

        assertEquals("Prince", result.get(0).getInstructorName());
        assertEquals(1L, result.get(0).getCourseCount());

        assertEquals("Hardik", result.get(1).getInstructorName());
        assertEquals(1L, result.get(1).getCourseCount());
    }
}