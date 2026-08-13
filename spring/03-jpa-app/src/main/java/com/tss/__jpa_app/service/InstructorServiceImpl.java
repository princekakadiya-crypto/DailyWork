package com.tss.__jpa_app.service;

import com.tss.__jpa_app.dto.*;
import com.tss.__jpa_app.entity.Course;
import com.tss.__jpa_app.entity.Instructor;
import com.tss.__jpa_app.entity.Student;
import com.tss.__jpa_app.exception.CourseNotFoundException;
import com.tss.__jpa_app.exception.InstructorNotFoundException;
import com.tss.__jpa_app.exception.NotFoundException;
import com.tss.__jpa_app.mapping.CourseMapping;
import com.tss.__jpa_app.mapping.InstructorMapping;
import com.tss.__jpa_app.repository.CourseRepository;
import com.tss.__jpa_app.repository.InstructorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class InstructorServiceImpl implements InstructorService{
    private final InstructorMapping instructorMapping;
    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;
    private final CourseMapping courseMapping;
    @Override
    public InstructorResponseDto addInstructor(InstructorRequestDto instructorRequestDto) {
        Instructor instructor=instructorMapping.dtoToInstructor(instructorRequestDto);
        Instructor result=instructorRepository.save(instructor);
        return instructorMapping.instructorToInstructorResponseDto(result);
    }

    @Override
    public PageDto getAllInstructor(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Instructor> instructors = instructorRepository.findAll(pageable);
        List<InstructorResponseDto> responseDtos = new ArrayList<>();

        for (Instructor instructor : instructors.getContent()) {
            InstructorResponseDto dto = instructorMapping.instructorToInstructorResponseDto(instructor);
            responseDtos.add(dto);
        }

        PageDto<InstructorResponseDto> pageDto=new PageDto<>();
        pageDto.setContent(responseDtos);
        pageDto.setEmpty(instructors.isEmpty());
        pageDto.setFirst(instructors.isFirst());
        pageDto.setLast(instructors.isLast());
        pageDto.setTotalPages(instructors.getTotalPages());
        pageDto.setTotalElement(instructors.getTotalElements());

        return pageDto;
    }

    public void assignCourse(Long instructorId,Long courseId){
        Instructor instructor=instructorRepository.findById(instructorId).orElseThrow(
                ()->new InstructorNotFoundException(instructorId)
        );

        Course course=courseRepository.findById(courseId).orElseThrow(
                ()-> new CourseNotFoundException(courseId)
        );

        instructor.getCourses().add(course);
        instructorRepository.save(instructor);
    }

    @Override
    public List<CourseResponseDto> getCourseByInstructorId(Long instructorId) {
        Instructor instructor=instructorRepository.findById(instructorId).orElseThrow(
                ()->new InstructorNotFoundException(instructorId)
        );
        List<Course> courses=instructor.getCourses();
        List<CourseResponseDto> courseResponseDtos=new ArrayList<>();

        for (Course course:courses){
            courseResponseDtos.add(courseMapping.courseToCourseResponseDto(course));
        }
        return courseResponseDtos;
    }

    @Override
    public Long getCourseCountByInstructor(Long instructorId) {
        return courseRepository.countCoursesByInstructorId(instructorId);
        //return (long) instructor.getCourses().size();
    }

    @Override
    public List<CoursesCountDto> getCoursesCount() {
//        List<Instructor> instructors=instructorRepository.findAll();
//
//        return instructors.stream().map(
//                instructor -> new CoursesCountDto(
//                        instructor.getInstructorName(),
//                        instructor.getCourses().size()
//                )
//        ).toList();

        return courseRepository.getCourseCounts();

    }

    @Override
    public boolean canDeleteInstructor(Long instructorId) {
        Long count= courseRepository.countCoursesByInstructorId(instructorId);

        return count==0;
    }


}
