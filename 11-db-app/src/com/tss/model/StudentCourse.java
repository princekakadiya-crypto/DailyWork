package com.tss.model;

import java.sql.Date;

public class StudentCourse {
    private int studentId;
    private String studentName;
    private int age;

    private int courseId;
    private String courseName;

    private Date enrollmentDate;

    public StudentCourse() {
    }

    public StudentCourse(int studentId, String studentName, int age, int courseId, String courseName, Date enrollmentDate) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.courseId = courseId;
        this.courseName = courseName;
        this.enrollmentDate = enrollmentDate;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getAge() {
        return age;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }
}
