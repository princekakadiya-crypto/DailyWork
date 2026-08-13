package com.tss.__jpa_app.service;

import com.tss.__jpa_app.dto.*;
import com.tss.__jpa_app.entity.Course;
import com.tss.__jpa_app.entity.Instructor;
import com.tss.__jpa_app.entity.Student;
import com.tss.__jpa_app.exception.CourseNotFoundException;
import com.tss.__jpa_app.exception.InstructorNotFoundException;
import com.tss.__jpa_app.exception.StudentNotFoundException;
import com.tss.__jpa_app.mapping.CourseMapping;
import com.tss.__jpa_app.mapping.InstructorMapping;
import com.tss.__jpa_app.mapping.StudentMapping;
import com.tss.__jpa_app.repository.CourseRepository;
import com.tss.__jpa_app.repository.InstructorRepository;
import com.tss.__jpa_app.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService{
    private final CourseMapping courseMapping;
    private final CourseRepository courseRepository;
    private final InstructorMapping instructorMapping;
    private final InstructorRepository instructorRepository;
    private final StudentRepository studentRepository;
    private final StudentMapping studentMapping;

    private static final Logger logger= LoggerFactory.getLogger(CourseServiceImpl.class);

    @Override
    public CourseResponseDto addCourse(CourseRequestDto courseRequestDto) {
        Course course=courseMapping.dtoToCourse(courseRequestDto);
        Course result=courseRepository.save(course);
        logger.info("Course Saved with id : "+result.getCourseId());
        return courseMapping.courseToCourseResponseDto(result);
    }

    @Override
    public PageDto getAllCourse(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Course> courses = courseRepository.findAll(pageable);
        List<CourseResponseDto> responseDtos = new ArrayList<>();

        for (Course course : courses.getContent()) {
            CourseResponseDto dto = courseMapping.courseToCourseResponseDto(course);
            responseDtos.add(dto);
        }

        PageDto<CourseResponseDto> pageDto=new PageDto<>();
        pageDto.setContent(responseDtos);
        pageDto.setEmpty(courses.isEmpty());
        pageDto.setFirst(courses.isFirst());
        pageDto.setLast(courses.isLast());
        pageDto.setTotalPages(courses.getTotalPages());
        pageDto.setTotalElement(courses.getTotalElements());

        return pageDto;
    }

    public void assignCourse(Long courseId,Long instructorId){

        Course course=courseRepository.findById(courseId).orElseThrow(
                ()-> new CourseNotFoundException(courseId)
        );

        Instructor instructor=instructorRepository.findById(instructorId).orElseThrow(
                ()->new InstructorNotFoundException(instructorId)
        );

        course.setInstructor(instructor);
        courseRepository.save(course);
    }

    @Override
    @Transactional
    public void assignStudents(Long courseId, AssignStudentsRequest studentsRequest) {
        Course course=courseRepository.findById(courseId)
                .orElseThrow(()->new CourseNotFoundException(courseId));

        for (Long studentId: studentsRequest.getStudentId()){
        Student student=studentRepository.findById(studentId)
                .orElseThrow(()->new StudentNotFoundException(studentId));

        student.getCourses().add(course);
        studentRepository.save(student);
        }
    }

    @Override
    public List<StudentResponseDto> getStudentByCourseId(Long courseId) {
        Course course=courseRepository.findById(courseId)
                .orElseThrow(()->new CourseNotFoundException(courseId));

        List<StudentResponseDto> responseDtos=new ArrayList<>();

        for (Student student:course.getStudents()){
            responseDtos.add(studentMapping.studentToStudentResponseDto(student));
        }
        return responseDtos;
    }

    @Override
    public InstructorResponseDto getInstructorByCourseId(Long courseId) {
        Course course=courseRepository.findById(courseId).orElseThrow(
                ()->new CourseNotFoundException(courseId)
        );

        Instructor instructor=course.getInstructor();
        return instructorMapping.instructorToInstructorResponseDto(instructor);
    }
}
