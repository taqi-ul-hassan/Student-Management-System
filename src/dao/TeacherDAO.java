package dao;

import java.sql.*;
import db.DBConnection;
import model.Teacher;

public class TeacherDAO {
    public void addTeacher(Teacher t) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "insert into teachers (id,name,subject) VALUES (?,?,?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, t.getId());
            pst.setString(2, t.getName());
            pst.setString(3, t.getSubject());
            pst.executeUpdate();
            pst.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllTeachers() {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "Select * from teachers";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String subject = rs.getString("subject");

                System.out.println(id + "---" + name + "---" + subject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTeacher(Teacher t) {
    try {
        Connection conn = DBConnection.getConnection();

        String query = "UPDATE teachers SET name = ?, subject = ? WHERE id = ?";
        PreparedStatement pst = conn.prepareStatement(query);

        pst.setString(1, t.getName());
        pst.setString(2, t.getSubject());
        pst.setInt(3, t.getId());

        int rows = pst.executeUpdate();

        if (rows > 0) {
            System.out.println("Teacher updated successfully");
        } else {
            System.out.println("Teacher not found!");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void deleteTeacher(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "DELETE FROM teachers WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Teacher deleted successfully");
            pst.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean teacherExists(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM teachers WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
