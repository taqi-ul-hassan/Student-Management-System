package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBConnection;
import model.Enrollment;

public class EnrollmentDAO {

    // ENROLL STUDENT
    public void enrollStudent(Enrollment e) {
        try {
            StudentDAO sDao = new StudentDAO();
            CourseDAO cDao = new CourseDAO();

            // VALIDATION
            if (!sDao.studentExists(e.getStudentId())) {
                System.out.println("Student does not exist!");
                return;
            }

            if (!cDao.courseExists(e.getCourseId())) {
                System.out.println("Course does not exist!");
                return;
            }

            if (enrollmentExists(e.getStudentId(), e.getCourseId())) {
                System.out.println("Student already enrolled in this course!");
                return;
            }

            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO enrollments (student_id, course_id) VALUES (?,?)";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, e.getStudentId());
            pst.setInt(2, e.getCourseId());

            pst.executeUpdate();
            System.out.println("Enrollment successful");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // CHECK IF ENROLLMENT EXISTS
    public boolean enrollmentExists(int studentId, int courseId) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM enrollments WHERE student_id = ? AND course_id = ?";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, studentId);
            pst.setInt(2, courseId);

            ResultSet rs = pst.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // VIEW ALL ENROLLMENTS
    public void getAllEnrollments() {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM enrollments";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                int courseId = rs.getInt("course_id");

                System.out.println("Student ID: " + studentId + " → Course ID: " + courseId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE ENROLLMENT
    public void deleteEnrollment(int studentId, int courseId) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "DELETE FROM enrollments WHERE student_id = ? AND course_id = ?";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, studentId);
            pst.setInt(2, courseId);

            pst.executeUpdate();
            System.out.println("Enrollment deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}