package com.tss.__jpa_app.repository;

import com.tss.__jpa_app.dto.CoursesCountDto;
import com.tss.__jpa_app.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    @Query("""
        SELECT COUNT(c)
        FROM Course c
        WHERE c.instructor.instructorId = :instructorId
    """)
    Long countCoursesByInstructorId(@Param("instructorId") Long instructorId);


    @Query("""
        SELECT new com.tss.__jpa_app.dto.CoursesCountDto(
            i.instructorName,
            COUNT(c)
        )
        FROM Instructor i
        LEFT JOIN i.courses c
        GROUP BY i.instructorId, i.instructorName
    """)
    List<CoursesCountDto> getCourseCounts();
}
