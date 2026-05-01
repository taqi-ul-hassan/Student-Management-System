package main;

import java.util.Scanner;

import dao.StudentDAO;
import dao.TeacherDAO;
import dao.CourseDAO;
import dao.EnrollmentDAO;
import model.student;
import model.Teacher;
import model.Course;
import model.Enrollment;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDAO sDao = new StudentDAO();
        TeacherDAO tDao = new TeacherDAO();
        CourseDAO cDao = new CourseDAO();
        EnrollmentDAO eDao = new EnrollmentDAO();

        int choice;

        do {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Teachers");
            System.out.println("3. Manage Courses");
            System.out.println("4. Manage Enrollment");
            System.out.println("5. Exit");

            choice = sc.nextInt();

            switch (choice) {

                // ================= STUDENTS =================
                case 1:
                    System.out.println("\n--- STUDENT MENU ---");
                    System.out.println("1. Add Student");
                    System.out.println("2. View Students");
                    int sChoice = sc.nextInt();

                    if (sChoice == 1) {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Age: ");
                        int age = sc.nextInt();

                        student s = new student();
                        s.setId(id);
                        s.setName(name);
                        s.setAge(age);

                        sDao.addStudent(s);

                    } else if (sChoice == 2) {
                        sDao.getAllStudents();
                    }
                    break;

                // ================= TEACHERS =================
                case 2:
                    System.out.println("\n--- TEACHER MENU ---");
                    System.out.println("1. Add Teacher");
                    System.out.println("2. View Teachers");
                    int tChoice = sc.nextInt();

                    if (tChoice == 1) {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Subject: ");
                        String subject = sc.nextLine();

                        Teacher t = new Teacher();
                        t.setId(id);
                        t.setName(name);
                        t.setSubject(subject);

                        tDao.addTeacher(t);

                    } else if (tChoice == 2) {
                        tDao.getAllTeachers();
                    }
                    break;

                // ================= COURSES =================
                case 3:
                    System.out.println("\n--- COURSE MENU ---");
                    System.out.println("1. Add Course");
                    System.out.println("2. View Courses");
                    int cChoice = sc.nextInt();

                    if (cChoice == 1) {
                        System.out.print("Enter Course ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Course Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Teacher ID: ");
                        int teacherId = sc.nextInt();

                        Course c = new Course();
                        c.setId(id);
                        c.setName(name);
                        c.setTeacherId(teacherId);

                        cDao.addCourse(c);

                    } else if (cChoice == 2) {
                        cDao.getAllCourses();
                    }
                    break;

                // ================= ENROLLMENT =================
                case 4:
                    System.out.println("\n--- ENROLLMENT MENU ---");
                    System.out.println("1. Enroll Student");
                    System.out.println("2. View Enrollments");
                    int eChoice = sc.nextInt();

                    if (eChoice == 1) {
                        System.out.print("Enter Student ID: ");
                        int studentId = sc.nextInt();

                        System.out.print("Enter Course ID: ");
                        int courseId = sc.nextInt();

                        Enrollment e = new Enrollment();
                        e.setStudentId(studentId);
                        e.setCourseId(courseId);

                        eDao.enrollStudent(e);

                    } else if (eChoice == 2) {
                        eDao.getAllEnrollments();
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}