package com.tss.repository;

import com.tss.db.Database;
import com.tss.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    PreparedStatement preparedStatement;
    Connection connection= Database.getDatabase().getConnection();

    public void addStudent(Student student){
        try {

            preparedStatement=connection.prepareStatement("insert into student(student_name,age) values(?,?)");

            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setInt(2,student.getAge());

            preparedStatement.executeUpdate();
            System.out.println("record inserted");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void updateStudent(Student student){
        try {
            preparedStatement = connection.prepareStatement("update student set student_name=?,age=? where student_id=?;");

            preparedStatement.setInt(3,student.getStudentId());
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setInt(2,student.getAge());

            int row=preparedStatement.executeUpdate();
            if (row>0)
                System.out.println("record update");
            else
                System.out.println("Id not found");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void deleteStudent(int id){
        try{
            preparedStatement=connection.prepareStatement("delete from student where student_id=?;");

            preparedStatement.setInt(1,id);

            int row=preparedStatement.executeUpdate();
            if (row>0)
                System.out.println("record deleted");
            else
                System.out.println("Id not found");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public List<Student> getStudents(){
        List<Student> students=new ArrayList<>();
        try {
            preparedStatement=connection.prepareStatement("select * from student");
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                Student student=new Student();
                student.setStudentId(resultSet.getInt(1));
                student.setStudentName(resultSet.getString(2));
                student.setAge(resultSet.getInt(3));

                students.add(student);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    public boolean studentExists(int studentId) {
        try {
            preparedStatement = connection.prepareStatement("SELECT 1 FROM student WHERE student_id = ?");
            preparedStatement.setInt(1, studentId);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
