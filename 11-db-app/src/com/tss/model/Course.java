package com.tss.model;

public class Course {
    int courseId;
    String courseName;
    int durationMonth;
    double fees;
    String description;

    public Course(String courseName, int durationMonth, double fees, String description) {
        this.courseName = courseName;
        this.durationMonth = durationMonth;
        this.fees = fees;
        this.description = description;
    }

    public Course(int courseId, String courseName, int durationMonth, double fees, String description) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.durationMonth = durationMonth;
        this.fees = fees;
        this.description = description;
    }

    public Course() {
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDurationMonth() {
        return durationMonth;
    }

    public void setDurationMonth(int durationMonth) {
        this.durationMonth = durationMonth;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
