package main;
import model.student;

import java.util.Scanner;

import dao.StudentDAO;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        StudentDAO sDao = new StudentDAO();
        do {
            System.out.println("\nChoose your required option:");
            System.out.println("1: ADD student");
            System.out.println("2: VIEW student");
            System.out.println("3: UPDATE student");
            System.out.println("4: DELETE student");
            System.out.println("5: EXIT");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Adding student...");
                    System.out.println("Please type your id: ");
                    int id = sc.nextInt();
                    while (id <= 0 || sDao.studentExists(id)) {
                        if (id <= 0) {
                            System.out.println("Invalid ID! Enter again: ");
                        } else {
                            System.out.println("ID already exists! Enter a different ID: ");
                        }
                        id = sc.nextInt();
                    }
                    sc.nextLine();
                    System.out.println("Please type your name: ");
                    String name = sc.nextLine();
                    while (name.trim().isEmpty()) {
                        System.out.println("Name cannot be empty. Please enter again: ");
                        name = sc.nextLine();
                    }
                    System.out.println("Please type your age: ");
                    int age = sc.nextInt();
                    while (age <= 0 || age > 120) {
                    System.out.println("Enter valid age (1-120): ");
                    age = sc.nextInt();
                    }
                    student s1 = new student();
                    s1.setId(id);
                    s1.setName(name);
                    s1.setAge(age);
                    sDao.addStudent(s1);
                    break;

                case 2:
                    System.out.println("Viewing student...");
                    sDao.getAllStudents();
                    break;

                case 3:
                System.out.println("Updating student...");
                System.out.print("Enter ID to update: ");
                int uid = sc.nextInt();

                while (!sDao.studentExists(uid)) {
                    System.out.println("Student doesn't exist!");
                    System.out.println("Please type a valid id: ");
                    uid = sc.nextInt();
                }

                sc.nextLine();

                System.out.print("Enter new name: ");
                String uname = sc.nextLine();
                while (uname.trim().isEmpty()) {
                    System.out.println("Name cannot be empty. Enter again:");
                    uname = sc.nextLine();
                }

                System.out.print("Enter new age: ");
                int uage = sc.nextInt();
                while (uage <= 0 || uage > 120) {
                    System.out.println("Enter valid age (1-120): ");
                    uage = sc.nextInt();
                }

                student us = new student();
                us.setId(uid);
                us.setName(uname);
                us.setAge(uage);

                sDao.updateStudent(us);

                System.out.println("Student updated successfully!\n");
                break;
                case 4:
                    System.out.println("Deleting student...");
                    System.out.print("Enter ID: ");
                    int user_id = sc.nextInt();
                    while (!sDao.studentExists(user_id)) {
                        System.out.println("Student not found!");
                        System.out.println("Please type a valid id: ");
                        user_id = sc.nextInt();
                    }
                    sDao.deleteStudent(user_id); 
                    System.out.println("Student deleted successfully!\n");
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