package com.employee.controller;

import java.time.LocalDate;
import java.util.List;

import com.employee.dao.EmployeeDAO;
import com.employee.dao.SalaryDAO;
import com.employee.dao.ReviewDAO;

import com.employee.entity.Employee;
import com.employee.entity.SalaryRecord;
import com.employee.entity.PerformanceReview;

import com.employee.util.CreateDatabase;

public class Main {

    public static void main(String[] args) {

//        CreateDatabase.createDB();

        EmployeeDAO empDao = new EmployeeDAO();
        SalaryDAO salaryDao = new SalaryDAO();
        ReviewDAO reviewDao = new ReviewDAO();


        // =====================================================
        // INSERT 6 EMPLOYEES
        // =====================================================

//        Employee e1 = new Employee();
//        e1.setEmployeeCode("EMP101");
//        e1.setName("Riya");
//        e1.setEmail("riya@gmail.com");
//        e1.setDesignation("Developer");
//        e1.setDepartment("IT");
//        e1.setJoiningDate(LocalDate.now());
//        e1.setActive(true);

        Employee e2 = new Employee();
        e2.setEmployeeCode("EMP102");
        e2.setName("Rahul");
        e2.setEmail("rahul@gmail.com");
        e2.setDesignation("Tester");
        e2.setDepartment("QA");
        e2.setJoiningDate(LocalDate.now());
        e2.setActive(true);

        Employee e3 = new Employee();
        e3.setEmployeeCode("EMP103");
        e3.setName("Amit");
        e3.setEmail("amit@gmail.com");
        e3.setDesignation("Manager");
        e3.setDepartment("HR");
        e3.setJoiningDate(LocalDate.now());
        e3.setActive(true);

        Employee e4 = new Employee();
        e4.setEmployeeCode("EMP104");
        e4.setName("Neha");
        e4.setEmail("neha@gmail.com");
        e4.setDesignation("Developer");
        e4.setDepartment("IT");
        e4.setJoiningDate(LocalDate.now());
        e4.setActive(true);

        Employee e5 = new Employee();
        e5.setEmployeeCode("EMP105");
        e5.setName("Karan");
        e5.setEmail("karan@gmail.com");
        e5.setDesignation("Support Engineer");
        e5.setDepartment("Support");
        e5.setJoiningDate(LocalDate.now());
        e5.setActive(true);

        Employee e6 = new Employee();
        e6.setEmployeeCode("EMP106");
        e6.setName("Priya");
        e6.setEmail("priya@gmail.com");
        e6.setDesignation("Designer");
        e6.setDepartment("UI/UX");
        e6.setJoiningDate(LocalDate.now());
        e6.setActive(true);

        // empDao.insertEmployee(e1);
        empDao.insertEmployee(e2);
        empDao.insertEmployee(e3);
        empDao.insertEmployee(e4);
        empDao.insertEmployee(e5);
        empDao.insertEmployee(e6);

        System.out.println("6 Employees Inserted");


        // =====================================================
        // UPDATE EMPLOYEE USING EMPLOYEE CODE
        // =====================================================

        empDao.updateEmployee(
                "EMP101",
                "Riya Sharma",
                "riya.sharma@gmail.com",
                "Senior Developer",
                "Product"
        );

        System.out.println("Employee Updated");


        // =====================================================
        // SOFT DELETE EMPLOYEE
        // =====================================================

        empDao.softDeleteEmployee("EMP106");

        System.out.println("Employee Soft Deleted");


        // =====================================================
        // FETCH EMPLOYEE BY ID
        // =====================================================

        Employee emp = empDao.getEmployeeById(1);

        System.out.println("Employee by ID: " + emp.getName());


        // =====================================================
        // FETCH EMPLOYEE BY CODE
        // =====================================================

        Employee emp2 = empDao.getEmployeeByCode("EMP102");

        System.out.println("Employee by Code: " + emp2.getName());


        // =====================================================
        // FETCH ALL ACTIVE EMPLOYEES
        // =====================================================

        List<Employee> activeEmployees = empDao.getAllActiveEmployees();

        System.out.println("Active Employees:");

        for(Employee e : activeEmployees) {

            System.out.println(e.getEmployeeCode()+" "+e.getName());
        }


        // =====================================================
        // SALARY RECORD OPERATIONS
        // =====================================================

        SalaryRecord s1 = new SalaryRecord();
        s1.setEmployeeCode("EMP101");
        s1.setBaseSalary(50000);
        s1.setBonus(5000);
        s1.setTax(3000);
        s1.setSalaryMonth("2026-03");

        SalaryRecord s2 = new SalaryRecord();
        s2.setEmployeeCode("EMP102");
        s2.setBaseSalary(45000);
        s2.setBonus(4000);
        s2.setTax(2500);
        s2.setSalaryMonth("2026-03");

        SalaryRecord s3 = new SalaryRecord();
        s3.setEmployeeCode("EMP103");
        s3.setBaseSalary(70000);
        s3.setBonus(8000);
        s3.setTax(5000);
        s3.setSalaryMonth("2026-03");

        salaryDao.insertSalary(s1);
        salaryDao.insertSalary(s2);
        salaryDao.insertSalary(s3);

        System.out.println("Salary Records Inserted");


        // =====================================================
        // UPDATE SALARY
        // =====================================================

        salaryDao.updateSalary(1, 6000, 3500);

        System.out.println("Salary Updated");


        // =====================================================
        // FETCH SALARY BY EMPLOYEE CODE
        // =====================================================

        List<SalaryRecord> salaries = salaryDao.getSalaryByEmployeeCode("EMP101");

        System.out.println("Salary Records of EMP101");

        for(SalaryRecord s : salaries) {

            System.out.println(s.getSalaryMonth()+" Net Salary: "+s.getNetSalary());
        }


        // =====================================================
        // FETCH SALARY BY MONTH
        // =====================================================

        List<SalaryRecord> march = salaryDao.getSalaryByMonth("2026-03");

        System.out.println("March Salaries");

        for(SalaryRecord s : march) {

            System.out.println(s.getEmployeeCode()+" "+s.getNetSalary());
        }


        // =====================================================
        // DELETE SALARY RECORD
        // =====================================================

        salaryDao.deleteSalary(3);

        System.out.println("Salary Deleted");


        // =====================================================
        // PERFORMANCE REVIEW OPERATIONS
        // =====================================================

        PerformanceReview r1 = new PerformanceReview();
        r1.setEmployeeCode("EMP101");
        r1.setRating(5);
        r1.setReviewDate(LocalDate.now());
        r1.setComments("Excellent Performance");

        PerformanceReview r2 = new PerformanceReview();
        r2.setEmployeeCode("EMP102");
        r2.setRating(4);
        r2.setReviewDate(LocalDate.now());
        r2.setComments("Very Good Work");

        reviewDao.insertReview(r1);
        reviewDao.insertReview(r2);

        System.out.println("Reviews Inserted");


        // =====================================================
        // UPDATE REVIEW
        // =====================================================

        reviewDao.updateReview(1,4,"Good Performance");

        System.out.println("Review Updated");


        // =====================================================
        // FETCH REVIEWS OF EMPLOYEE
        // =====================================================

        List<PerformanceReview> reviews = reviewDao.getReviewsByEmployee("EMP101");

        System.out.println("Reviews of EMP101");

        for(PerformanceReview r : reviews) {

            System.out.println(r.getRating()+" "+r.getComments());
        }


        // =====================================================
        // DELETE REVIEW
        // =====================================================

        reviewDao.deleteReview(2);

        System.out.println("Review Deleted");


        System.out.println("All Operations Completed Successfully");
    }
}