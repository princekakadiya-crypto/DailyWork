package com.tss.service;

import com.tss.InputUtil;
import com.tss.model.Course;
import com.tss.repository.CourseRepository;

import java.util.List;

public class CourseService {
    CourseRepository courseRepository=new CourseRepository();

    public void addCourse()
    {
        String courseName= InputUtil.readName("Enter Course Name : ");
        int durationMonth=InputUtil.readInt("Enter duration Month : ");
        double fees=InputUtil.readDouble("Enter Fees : ");
        String description=InputUtil.readDescription("Enter Course Description : ");

        Course course=new Course(courseName,durationMonth,fees,description);

        courseRepository.addCourse(course);
    }

    public void editCourse()
    {
        int courseId=InputUtil.readInt("Enter Course id : ");
        String courseName= InputUtil.readName("Enter Course Name : ");
        int durationMonth=InputUtil.readInt("Enter duration Month : ");
        double fees=InputUtil.readDouble("Enter Fees : ");
        String description=InputUtil.readDescription("Enter Course Description : ");

        Course course=new Course(courseId,courseName,durationMonth,fees,description);

        courseRepository.updateCourse(course);
    }

    public void deleteCourse()
    {
        int courseId=InputUtil.readInt("Enter Course Id : ");

        courseRepository.deleteCourse(courseId);
    }

    public void display()
    {
        List<Course> courses=courseRepository.getCourse();
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-5s %-20s %-10s %-10s %-20s%n", "ID", "Name", "Duration", "Fees", "Description");
        System.out.println("--------------------------------------------------------------");
        for (Course course : courses) {
            System.out.printf("%-5d %-20s %-10d %-10.2f %-20s%n",
                    course.getCourseId(),
                    course.getCourseName(),
                    course.getDurationMonth(),
                    course.getFees(),
                    course.getDescription());
        }
        System.out.println("--------------------------------------------------------------");
    }
}
