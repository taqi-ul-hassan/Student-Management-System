# Student Management System (Java + MySQL + GUI)

## Overview
This project is a Student Management System developed using Java, MySQL, and Swing GUI. It provides a simple and interactive interface to manage student records with full CRUD (Create, Read, Update, Delete) functionality.

The project demonstrates core concepts of Java programming, database connectivity using JDBC, and GUI development.

---

## Features

- Add new student records
- View all students in a table format
- Update existing student details
- Delete students by ID
- Input validation (ID, name, age)
- Duplicate ID prevention
- "Student not found" handling
- GUI-based interaction using Java Swing

---

## Technologies Used

- Java (Core Java, Swing)
- MySQL Database
- JDBC (Java Database Connectivity)

---

## Project Structure


src/
├── dao/
│ └── StudentDAO.java

├── db/
│ └── DBConnection.java

├── model/
│ └── Student.java

├── gui/
│ └── StudentGUI.java

└── main/
└── Main.java

---
## Database Setup

Run the following SQL commands in MySQL:

```sql
CREATE DATABASE sms;
USE sms;

CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INT NOT NULL
);
How to Run
Clone the repository:
git clone https://github.com/YOUR_USERNAME/student-management-system.git
Navigate to the project directory:
cd student-management-system/src
Compile the project:
javac -cp ".;../lib/mysql-connector-j-9.7.0.jar" gui/StudentGUI.java dao/StudentDAO.java db/DBConnection.java model/Student.java
Run the application:
java -cp ".;../lib/mysql-connector-j-9.7.0.jar" gui.StudentGUI
Future Improvements
Display messages directly in GUI instead of console
Add search functionality by student ID
Improve GUI layout and styling
Add sorting and filtering options
Implement service layer for better architecture
Convert to web application using Spring Boot
Author:
Hafiz Taqi Ul Hassan
