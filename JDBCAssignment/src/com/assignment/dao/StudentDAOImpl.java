package com.assignment.dao;

import com.assignment.model.Student;
import com.assignment.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public void addStudent(Student student) {

        String sql = "INSERT INTO student(name,email,marks) VALUES(?,?,?)";

        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getMarks());

            ps.executeUpdate();

            System.out.println("Student Added");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Student getStudentById(int id) {

        String sql = "SELECT * FROM student WHERE id=?";

        Student student = null;

        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("marks")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }


    @Override
    public List<Student> getAllStudents() {

        String sql = "SELECT * FROM student";

        List<Student> list = new ArrayList<>();

        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {

                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("marks")
                );

                list.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    @Override
    public void updateStudent(Student student) {

        String sql = "UPDATE student SET name=?,email=?,marks=? WHERE id=?";

        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getMarks());
            ps.setInt(4, student.getId());

            ps.executeUpdate();

            System.out.println("Student Updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteStudent(int id) {

        String sql = "DELETE FROM student WHERE id=?";

        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Student Deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
