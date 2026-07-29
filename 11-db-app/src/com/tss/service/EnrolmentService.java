package com.tss.service;

import com.tss.InputUtil;
import com.tss.model.Enrollment;
import com.tss.model.StudentCourse;
import com.tss.repository.CourseRepository;
import com.tss.repository.EnrollmentRepository;
import com.tss.repository.StudentRepository;

import java.sql.Date;
import java.util.List;

public class EnrolmentService {
    EnrollmentRepository enrollmentRepository = new EnrollmentRepository();
    StudentRepository studentRepository=new StudentRepository();
    CourseRepository courseRepository=new CourseRepository();

    public void addEnrollment() {

        int studentId = InputUtil.readInt("Enter Student Id : ");
        if (!studentRepository.studentExists(studentId)){
            System.out.println("Student Id not Exists");
            return;
        }
        int courseId = InputUtil.readInt("Enter Course Id : ");
        if (!courseRepository.courseExists(courseId)){
            System.out.println("Course Id Not Exists");
            return;
        }

        Date enrollmentDate = InputUtil.readDate("Enter Enrollment Date (yyyy-MM-dd): ");

        Enrollment enrollment = new Enrollment(studentId, courseId, enrollmentDate);
        enrollmentRepository.addEnrollment(enrollment);
    }

    public void updateEnrollment() {

        int studentId = InputUtil.readInt("Enter Student Id : ");
        if (!studentRepository.studentExists(studentId)){
            System.out.println("Student Id not Exists");
            return;
        }
        int courseId = InputUtil.readInt("Enter Old Id : ");
        if (!courseRepository.courseExists(courseId)){
            System.out.println("Course Id Not Exists");
            return;
        }
        int newCourseId = InputUtil.readInt("Enter New Course Id : ");
        if (!courseRepository.courseExists(newCourseId)){
            System.out.println("Course Id Not Exists");
            return;
        }
        Date enrollmentDate = InputUtil.readDate("Enter Enrollment Date (yyyy-MM-dd): ");

        Enrollment enrollment = new Enrollment(studentId, courseId, enrollmentDate);

        enrollmentRepository.updateEnrollment(enrollment,newCourseId);
    }

    public void deleteEnrollment() {

        int studentId = InputUtil.readInt("Enter Student Id : ");
        if (!studentRepository.studentExists(studentId)){
            System.out.println("Student Id not Exists");
            return;
        }
        int courseId = InputUtil.readInt("Enter Course Id : ");
        if (!courseRepository.courseExists(courseId)){
            System.out.println("Course Id Not Exists");
            return;
        }

        enrollmentRepository.deleteEnrollment(studentId, courseId);
    }

    public void display() {

        List<Enrollment> enrollments = enrollmentRepository.getEnrollments();
        if (enrollments.isEmpty()) {
            System.out.println("No enrollments found.");
            return;
        }
        System.out.println("----------------------------------------------");
        System.out.printf("%-12s %-12s %-15s%n", "Student ID", "Course ID", "Enroll Date");
        System.out.println("----------------------------------------------");
        for (Enrollment enrollment : enrollments) {
            System.out.printf("%-12d %-12d %-15s%n",
                    enrollment.getStudentId(),
                    enrollment.getCourseId(),
                    enrollment.getEnrollmentDate());
        }
        System.out.println("----------------------------------------------");
    }

    public void showStudentCourse(){

        List<StudentCourse> studentCourses=enrollmentRepository.getStudentCourses();

        if (studentCourses.isEmpty()) {
            System.out.println("No enrollment records found.");
            return;
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-5s %-20s %-5s %-5s %-20s %-15s%n", "SID", "Student Name", "Age", "CID", "Course Name", "Enroll Date");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        for (StudentCourse sc : studentCourses) {
            System.out.printf("%-5d %-20s %-5d %-5d %-20s %-15s%n",
                    sc.getStudentId(),
                    sc.getStudentName(),
                    sc.getAge(),
                    sc.getCourseId(),
                    sc.getCourseName(),
                    sc.getEnrollmentDate());
        }
    }
}
