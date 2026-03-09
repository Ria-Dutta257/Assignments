package com.assignment.main;

import com.assignment.dao.StudentDAO;
import com.assignment.dao.StudentDAOImpl;
import com.assignment.model.Student;
import com.assignment.util.CreateTable;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CreateTable.createStudentTable();

        StudentDAO dao = new StudentDAOImpl();

        dao.addStudent(new Student("Riya","riya@gmail.com",90));
        dao.addStudent(new Student("Rahul","rahul@gmail.com",85));
        dao.addStudent(new Student("Amit","amit@gmail.com",80));

        Student s = dao.getStudentById(1);

        System.out.println("Student Name: "+s.getName());

        List<Student> list = dao.getAllStudents();

        System.out.println("All Students");

        for(Student st : list) {

            System.out.println(st.getId()+" "
                    +st.getName()+" "
                    +st.getMarks());
        }

        dao.updateStudent(new Student(1,"Riya Sharma","riya@gmail.com",95));

        dao.deleteStudent(2);
    }
}
