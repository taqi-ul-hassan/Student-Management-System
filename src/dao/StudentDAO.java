package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSet;
import db.DBConnection;
import model.student;

public class StudentDAO {
    public void addStudent(student s) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "insert into students VALUES (?,?,?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, s.getId());
            pst.setString(2, s.getName());
            pst.setInt(3, s.getAge());
            pst.executeUpdate();
            System.out.println("Student added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllStudents() {
        try{
        Connection conn = DBConnection.getConnection();
        String query = "Select * from students";
        PreparedStatement pst = conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            rs.getInt("id");
            rs.getString("name");
            rs.getInt("age");
            System.out.println(rs.getInt("id") + "---" + rs.getString("name") + "---" + rs.getInt("age"));
        }
    }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void updateStudent(student s){
    try{
        Connection conn = DBConnection.getConnection();
        String query = "UPDATE students SET name = ?, age = ? WHERE id = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, s.getName());
        pst.setInt(2, s.getAge());
        pst.setInt(3, s.getId());
        pst.executeUpdate();
        System.out.println("Student updated successfully");
    } catch(Exception e){
        e.printStackTrace();
    }
    }
    public void deleteStudent(int id){
        try{
        Connection conn = DBConnection.getConnection();
        String query  = "DELETE FROM students WHERE id = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, id);
        pst.executeUpdate();
    }catch(Exception e){
        e.printStackTrace();
    }
}
    public boolean studentExists(int id){
        try{
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM students WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public ResultSet getStudentsResultSet(){
    try{
        Connection conn = DBConnection.getConnection();
        String query = "SELECT * FROM students";
        PreparedStatement pst = conn.prepareStatement(query);
        return pst.executeQuery();
    } catch(Exception e){
        e.printStackTrace();
        return null;
    }
}
}
