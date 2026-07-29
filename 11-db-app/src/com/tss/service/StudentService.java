package com.tss.service;

import com.tss.InputUtil;
import com.tss.db.Database;
import com.tss.model.Student;
import com.tss.repository.StudentRepository;

import java.util.List;

public class StudentService {

    StudentRepository studentRepository=new StudentRepository();

    public void addStudent(){
        String name=InputUtil.readName("Enter Name : ");
        int age=InputUtil.readInt("Enter age : ");
        Student student=new Student();
        student.setStudentName(name);
        student.setAge(age);
        studentRepository.addStudent(student);
    }

    public void editStudent(){
        int id=InputUtil.readInt("Enter ID :");
        String name=InputUtil.readName("Enter Name : ");
        int age=InputUtil.readInt("Enter age : ");
        Student student=new Student(id,name,age);
        studentRepository.updateStudent(student);
    }

    public void deleteStudent(){
        int id=InputUtil.readInt("Enter ID : ");
        studentRepository.deleteStudent(id);
    }

    public void display(){
        List<Student> students = studentRepository.getStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.printf("%-10s %-25s %-5s%n", "ID", "Name", "Age");
        System.out.println("-------------------------------------------");
        for (Student student : students) {
            System.out.printf("%-10d %-25s %-5d%n",
                    student.getStudentId(),
                    student.getStudentName(),
                    student.getAge());
        }
    }
}
