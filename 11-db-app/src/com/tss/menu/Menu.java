package com.tss.menu;

import com.tss.InputUtil;
import com.tss.service.CourseService;
import com.tss.service.EnrolmentService;
import com.tss.service.StudentService;

public class Menu {
    public void showMenu() {
        while (true){
            System.out.println();
            System.out.println("1. Manage Student");
            System.out.println("2. Manage Course");
            System.out.println("3. Manage Enrollment");
            System.out.println("4. Exit");
            System.out.println();
            int choice=InputUtil.readInt("Enter choice : ");

            switch (choice){
                case 1:
                    showStudentMenu();
                    break;
                case 2:
                    showCourseMenu();
                    break;
                case 3:
                    showEnrollment();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }

    private void showStudentMenu(){
        StudentService service=new StudentService();
        while (true) {
            System.out.println();
            System.out.println("1. Add student");
            System.out.println("2. Edit student");
            System.out.println("3. Delete student");
            System.out.println("4. show student");
            System.out.println("5. Back");
            System.out.println();
            int choice=InputUtil.readInt("Enter choice : ");
            switch (choice){
                case 1:
                    service.addStudent();
                    break;
                case 2:
                    service.editStudent();
                    break;
                case 3:
                    service.deleteStudent();
                    break;
                case 4:
                    service.display();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void showCourseMenu(){
        CourseService service=new CourseService();
        while (true) {
            System.out.println();
            System.out.println("1. Add Course");
            System.out.println("2. Edit Course");
            System.out.println("3. Delete Course");
            System.out.println("4. show Course");
            System.out.println("5. Back");
            System.out.println();
            int choice=InputUtil.readInt("Enter choice : ");
            switch (choice){
                case 1:
                    service.addCourse();
                    break;
                case 2:
                    service.editCourse();
                    break;
                case 3:
                    service.deleteCourse();
                    break;
                case 4:
                    service.display();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void showEnrollment(){
        EnrolmentService service=new EnrolmentService();
        while (true) {
            System.out.println();
            System.out.println("1. Enroll Student");
            System.out.println("2. Edit Enrollment");
            System.out.println("3. Delete Enrollment");
            System.out.println("4. show Enrollment");
            System.out.println("5. show students course");
            System.out.println("6. Back");
            System.out.println();
            int choice=InputUtil.readInt("Enter choice : ");
            switch (choice){
                case 1:
                    service.addEnrollment();
                    break;
                case 2:
                    service.updateEnrollment();
                    break;
                case 3:
                    service.deleteEnrollment();
                    break;
                case 4:
                    service.display();
                    break;
                case 5:
                    service.showStudentCourse();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
