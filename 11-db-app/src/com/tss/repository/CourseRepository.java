package com.tss.repository;

import com.tss.db.Database;
import com.tss.model.Course;
import com.tss.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    PreparedStatement preparedStatement;
    Connection connection= Database.getDatabase().getConnection();

    public void addCourse(Course course){
        try{
            preparedStatement=connection.prepareStatement("insert into course(course_name,duration_month,fees,description) values (?,?,?,?)");

            preparedStatement.setString(1, course.getCourseName());
            preparedStatement.setInt(2,course.getDurationMonth());
            preparedStatement.setDouble(3,course.getFees());
            preparedStatement.setString(4,course.getDescription());

            preparedStatement.executeUpdate();
            System.out.println("Course Added");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void updateCourse(Course course){
        try {
            preparedStatement = connection.prepareStatement("update course set course_name=?,duration_month=?,fees=?,description=? where course_id=?;");

            preparedStatement.setString(1, course.getCourseName());
            preparedStatement.setInt(2,course.getDurationMonth());
            preparedStatement.setDouble(3,course.getFees());
            preparedStatement.setString(4,course.getDescription());
            preparedStatement.setInt(5,course.getCourseId());

            int row=preparedStatement.executeUpdate();
            if (row>0)
                System.out.println("course update");
            else
                System.out.println("Id not found");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void deleteCourse(int id){
        try{
            preparedStatement=connection.prepareStatement("delete from Course where course_id=?;");
            preparedStatement.setInt(1,id);
            int row=preparedStatement.executeUpdate();
            if (row>0)
                System.out.println("course deleted");
            else
                System.out.println("Id not found");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public List<Course> getCourse(){
        List<Course> courses=new ArrayList<>();
        try {
            preparedStatement=connection.prepareStatement("select * from Course");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Course course=new Course();
                course.setCourseId(resultSet.getInt(1));
                course.setCourseName(resultSet.getString(2));
                course.setDurationMonth(resultSet.getInt(3));
                course.setFees(resultSet.getDouble(4));
                course.setDescription(resultSet.getString(5));
                courses.add(course);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return courses;
    }

    public boolean courseExists(int courseId) {
        try {
            preparedStatement = connection.prepareStatement("SELECT 1 FROM course WHERE course_id = ?");
            preparedStatement.setInt(1, courseId);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
