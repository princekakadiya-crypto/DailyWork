package com.tss.repository;

import com.tss.db.Database;
import com.tss.model.Enrollment;
import com.tss.model.StudentCourse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository {
    PreparedStatement preparedStatement;
    Connection connection = Database.getDatabase().getConnection();

    public void addEnrollment(Enrollment enrollment) {

        try {

            preparedStatement = connection.prepareStatement("insert into enrollment(student_id,course_id,enrollment_date) values (?,?,?)");

            preparedStatement.setInt(1, enrollment.getStudentId());
            preparedStatement.setInt(2, enrollment.getCourseId());
            preparedStatement.setDate(3, enrollment.getEnrollmentDate());

            preparedStatement.executeUpdate();

            System.out.println("Enrollment Added");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateEnrollment(Enrollment enrollment,int newCourseId) {

        try {

            preparedStatement = connection.prepareStatement("update enrollment set course_id=?, enrollment_date=? where student_id=? and course_id=?");

            preparedStatement.setInt(1, newCourseId);
            preparedStatement.setDate(2, enrollment.getEnrollmentDate());
            preparedStatement.setInt(3, enrollment.getStudentId());
            preparedStatement.setInt(4,enrollment.getCourseId());

            int row = preparedStatement.executeUpdate();

            if (row > 0)
                System.out.println("Enrollment Updated");
            else
                System.out.println("Student not found");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteEnrollment(int studentId, int courseId) {

        try {

            preparedStatement = connection.prepareStatement("delete from enrollment where student_id=? and course_id=?");

            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, courseId);

            int row = preparedStatement.executeUpdate();

            if (row > 0)
                System.out.println("Enrollment Deleted");
            else
                System.out.println("Record not found");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Enrollment> getEnrollments() {

        List<Enrollment> enrollments = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement("select * from enrollment");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Enrollment enrollment = new Enrollment(
                        resultSet.getInt("student_id"),
                        resultSet.getInt("course_id"),
                        resultSet.getDate("enrollment_date")
                );
                enrollments.add(enrollment);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return enrollments;
    }

    public List<StudentCourse> getStudentCourses() {

        List<StudentCourse> list = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(
                    "select s.student_id, s.student_name, s.age, c.course_id, c.course_name, e.enrollment_date " +
                            "from student s " +
                            "join enrollment e on s.student_id = e.student_id " +
                            "join course c on c.course_id = e.course_id");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                StudentCourse studentCourse = new StudentCourse();
                studentCourse.setStudentId(resultSet.getInt("student_id"));
                studentCourse.setStudentName(resultSet.getString("student_name"));
                studentCourse.setAge(resultSet.getInt("age"));
                studentCourse.setCourseId(resultSet.getInt("course_id"));
                studentCourse.setCourseName(resultSet.getString("course_name"));
                studentCourse.setEnrollmentDate(resultSet.getDate("enrollment_date"));
                list.add(studentCourse);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
