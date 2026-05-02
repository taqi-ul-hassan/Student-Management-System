# Student Management System (Java + MySQL)

## Overview
A terminal-based Student Management System built using Java and MySQL. 
It supports managing students, teachers, courses, and enrollments with full CRUD operations and relational integrity.

## Features
- Add, update, delete, and view students
- Manage teachers and assigned subjects
- Create courses linked to teachers
- Enroll students in courses (many-to-many relationship)
- Input validation and existence checks

## Technologies
- Java (JDBC)
- MySQL
- VS Code

## Project Structure
src/
 ├── dao/
 ├── db/
 ├── model/
 └── main/

## Database
Schema is provided in `sql/schema.sql`

## How to Run
1. Import database from schema.sql
2. Add MySQL connector JAR
3. Run Main.java

## Author
Your Name
