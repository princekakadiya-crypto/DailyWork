package com.tss.__jpa_app.service;

import com.tss.__jpa_app.dto.*;
import com.tss.__jpa_app.entity.Address;
import com.tss.__jpa_app.entity.Course;
import com.tss.__jpa_app.entity.Student;
import com.tss.__jpa_app.exception.AddressAlreadyInserted;
import com.tss.__jpa_app.exception.AddressNotFoundException;
import com.tss.__jpa_app.exception.CourseNotFoundException;
import com.tss.__jpa_app.exception.StudentNotFoundException;
import com.tss.__jpa_app.mapping.AddressMapping;
import com.tss.__jpa_app.mapping.CourseMapping;
import com.tss.__jpa_app.mapping.StudentMapping;
import com.tss.__jpa_app.repository.CourseRepository;
import com.tss.__jpa_app.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final StudentMapping studentMapping;
    private final AddressMapping addressMapping;
    private final CourseRepository courseRepository;
    private final CourseMapping courseMapping;

    @Override
    public PageDto<StudentResponseDto> getAllStudent(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Student> students = studentRepository.findAll(pageable);
        List<StudentResponseDto> responseDtos = new ArrayList<>();

        for (Student student : students.getContent()) {
            StudentResponseDto dto = studentMapping.studentToStudentResponseDto(student);
            responseDtos.add(dto);
        }

        PageDto<StudentResponseDto> pageDto=new PageDto<>();
        pageDto.setContent(responseDtos);
        pageDto.setEmpty(students.isEmpty());
        pageDto.setFirst(students.isFirst());
        pageDto.setLast(students.isLast());
        pageDto.setTotalPages(students.getTotalPages());
        pageDto.setTotalElement(students.getTotalElements());

        return pageDto;
    }

    @Override
    public StudentResponseDto getStudentById(Long id) {

        Student result= studentRepository.findById(id).orElseThrow(
                ()-> new StudentNotFoundException(id)
        );

        StudentResponseDto dto = studentMapping.studentToStudentResponseDto(result);
        return dto;
    }

    public StudentResponseDto addStudent(StudentRequestDto dto) {
        Student student=studentMapping.dtoToStudent(dto);

        Address address=new Address();
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setPincode(dto.getPincode());

        student.setAddress(address);

        Student result= studentRepository.save(student);
        return studentMapping.studentToStudentResponseDto(result);
    }

    @Override
    @Transactional
    public Integer deleteByAge(Integer age) {
//        List<Student> students=studentRepository.deleteByAge(age);
//
//        List<StudentResponseDto> responseDtos=new ArrayList<>();
//
//        for (Student student:students)
//            responseDtos.add(studentMapping.studentToStudentResponseDto(student));
//
//        return responseDtos;
        Integer row= studentRepository.deleteByAge(age);
        return row;
    }

    public AddressResponseDto getAddressByStudentId(Long id) {
        Student result= studentRepository.findById(id).orElseThrow(
                ()-> new StudentNotFoundException(id)
        );

        Address address=result.getAddress();
        if (address==null)
            throw new AddressNotFoundException();

        return addressMapping.toDto(address);
    }

    public StudentResponseDto addAddress(Long studentId, AddressRequestDto addRequestDto) {
        Student student=studentRepository.findById(studentId).orElseThrow(
                ()->new StudentNotFoundException(studentId)
        );

        if (student.getAddress()!=null)
            throw new AddressAlreadyInserted();

        Address address=addressMapping.toAddress(addRequestDto);
        student.setAddress(address);
        Student result=studentRepository.save(student);

        return studentMapping.studentToStudentResponseDto(result);
    }

    @Override
    public StudentResponseDto editAddress(Long studentId, AddressRequestDto addRequestDto) {
        Student student=studentRepository.findById(studentId).orElseThrow(
                ()->new StudentNotFoundException(studentId)
        );

        if (student.getAddress()==null)
            throw new AddressNotFoundException();

        Address address=student.getAddress();
        addressMapping.updateAddress(addRequestDto,address);

        Student result=studentRepository.save(student);

        return studentMapping.studentToStudentResponseDto(result);

    }

    @Override
    public void assignCourse(Long studentId, Long courseId) {
        Student student=studentRepository.findById(studentId)
                .orElseThrow(()->new StudentNotFoundException(studentId));

        Course course=courseRepository.findById(courseId)
                .orElseThrow(()->new CourseNotFoundException(courseId));

        student.getCourses().add(course);
        studentRepository.save(student);
    }

    @Override
    public void assignCourses(Long studentId, AssignCoursesRequest coursesRequest) {
        Student student=studentRepository.findById(studentId)
                .orElseThrow(()->new StudentNotFoundException(studentId));

        for (Long courseId: coursesRequest.getCourseIds()){
            Course course=courseRepository.findById(courseId)
                    .orElseThrow(()->new CourseNotFoundException(courseId));

            student.getCourses().add(course);
            studentRepository.save(student);
        }
    }

    @Override
    public List<CourseResponseDto> getCourseByStudentId(Long studentId) {
        Student student=studentRepository.findById(studentId)
                .orElseThrow(()->new StudentNotFoundException(studentId));
        List<CourseResponseDto> responseDtos=new ArrayList<>();

        for (Course course:student.getCourses()){
            responseDtos.add(courseMapping.courseToCourseResponseDto(course));
        }
        return responseDtos;
    }

//    private Student studentRequestDtoToStudent(StudentRequestDto dto){
//        Student student=new Student();
//        student.setName(dto.getName());
//        student.setAge(dto.getAge());
//        return student;
//    }
//
//    private StudentResponseDto studentToStudentResponseDto(Student student){
//        StudentResponseDto responseDto=new StudentResponseDto();
//        responseDto.setId(student.getId());
//        responseDto.setName(student.getName());
//        return responseDto;
//    }

}
