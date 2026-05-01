package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBConnection;
import model.Course;

public class CourseDAO {

    // ADD COURSE
    public void addCourse(Course c) {
        try {
            TeacherDAO tDao = new TeacherDAO();

            if (!tDao.teacherExists(c.getTeacherId())) {
                System.out.println("Teacher does not exist!");
                return;
            }

            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO courses (id, name, teacher_id) VALUES (?,?,?)";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, c.getId());
            pst.setString(2, c.getName());
            pst.setInt(3, c.getTeacherId());

            pst.executeUpdate();
            System.out.println("Course added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW ALL COURSES
    public void getAllCourses() {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM courses";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int teacherId = rs.getInt("teacher_id");

                System.out.println(id + " --- " + name + " --- " + teacherId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CHECK IF COURSE EXISTS
    public boolean courseExists(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM courses WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // UPDATE COURSE
    public void updateCourse(Course c) {
        try {
            TeacherDAO tDao = new TeacherDAO();

            if (!courseExists(c.getId())) {
                System.out.println("Course does not exist!");
                return;
            }

            if (!tDao.teacherExists(c.getTeacherId())) {
                System.out.println("Teacher does not exist!");
                return;
            }

            Connection conn = DBConnection.getConnection();
            String query = "UPDATE courses SET name = ?, teacher_id = ? WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, c.getName());
            pst.setInt(2, c.getTeacherId());
            pst.setInt(3, c.getId());

            pst.executeUpdate();
            System.out.println("Course updated successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE COURSE
    public void deleteCourse(int id) {
        try {
            if (!courseExists(id)) {
                System.out.println("Course not found!");
                return;
            }

            Connection conn = DBConnection.getConnection();
            String query = "DELETE FROM courses WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, id);
            pst.executeUpdate();

            System.out.println("Course deleted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}