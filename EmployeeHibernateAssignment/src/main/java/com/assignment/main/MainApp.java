package com.assignment.main;

import com.assignment.dao.EmployeeDAO;
import com.assignment.entity.Address;
import com.assignment.entity.Employee;

import java.time.LocalDate;

public class MainApp {

    public static void main(String[] args) {

    	EmployeeDAO dao = new EmployeeDAO();

    	/* ---------- Employee 1 ---------- */
    	Address a1 = new Address();
    	a1.setStreet("Park Street");
    	a1.setCity("Kolkata");
    	a1.setState("West Bengal");
    	a1.setCountry("India");
    	a1.setPincode("700016");

    	Employee e1 = new Employee();
    	e1.setEmployeeName("Riya Sharma");
    	e1.setEmail("[riya1@gmail.com](mailto:riya1@gmail.com)");
    	e1.setGender("Female");
    	e1.setPassword("12345");
    	e1.setPhone("9876543210");
    	e1.setSalary(20000);
    	e1.setDateOfBirth(LocalDate.of(1999,5,10));
    	e1.setAddress(a1);

    	dao.insertEmployee(e1);

    	/* ---------- Employee 2 ---------- */
    	Address a2 = new Address();
    	a2.setStreet("Salt Lake");
    	a2.setCity("Kolkata");
    	a2.setState("West Bengal");
    	a2.setCountry("India");
    	a2.setPincode("700091");

    	Employee e2 = new Employee();
    	e2.setEmployeeName("Rahul Das");
    	e2.setEmail("[rahul1@gmail.com](mailto:rahul1@gmail.com)");
    	e2.setGender("Male");
    	e2.setPassword("12345");
    	e2.setPhone("9123456780");
    	e2.setSalary(18000);
    	e2.setDateOfBirth(LocalDate.of(1997,8,12));
    	e2.setAddress(a2);

    	dao.insertEmployee(e2);

    	/* ---------- Employee 3 ---------- */
    	Address a3 = new Address();
    	a3.setStreet("MG Road");
    	a3.setCity("Delhi");
    	a3.setState("Delhi");
    	a3.setCountry("India");
    	a3.setPincode("110001");

    	Employee e3 = new Employee();
    	e3.setEmployeeName("Amit Kumar");
    	e3.setEmail("[amit1@gmail.com](mailto:amit1@gmail.com)");
    	e3.setGender("Male");
    	e3.setPassword("12345");
    	e3.setPhone("9988776655");
    	e3.setSalary(30000);
    	e3.setDateOfBirth(LocalDate.of(1995,2,20));
    	e3.setAddress(a3);

    	dao.insertEmployee(e3);

    	/* ---------- Employee 4 ---------- */
    	Address a4 = new Address();
    	a4.setStreet("Andheri");
    	a4.setCity("Mumbai");
    	a4.setState("Maharashtra");
    	a4.setCountry("India");
    	a4.setPincode("400053");

    	Employee e4 = new Employee();
    	e4.setEmployeeName("Neha Singh");
    	e4.setEmail("[neha1@gmail.com](mailto:neha1@gmail.com)");
    	e4.setGender("Female");
    	e4.setPassword("12345");
    	e4.setPhone("9001122334");
    	e4.setSalary(22000);
    	e4.setDateOfBirth(LocalDate.of(1999,11,15));
    	e4.setAddress(a4);

    	dao.insertEmployee(e4);

    	/* ---------- Employee 5 ---------- */
    	Address a5 = new Address();
    	a5.setStreet("Banjara Hills");
    	a5.setCity("Hyderabad");
    	a5.setState("Telangana");
    	a5.setCountry("India");
    	a5.setPincode("500034");

    	Employee e5 = new Employee();
    	e5.setEmployeeName("Karan Mehta");
    	e5.setEmail("[karan1@gmail.com](mailto:karan1@gmail.com)");
    	e5.setGender("Male");
    	e5.setPassword("12345");
    	e5.setPhone("9870011223");
    	e5.setSalary(27000);
    	e5.setDateOfBirth(LocalDate.of(1996,7,5));
    	e5.setAddress(a5);

    	dao.insertEmployee(e5);

    	System.out.println("5 Employees inserted successfully!");
        
        System.out.println("Employees with salary > 15000");

        dao.getEmployeesWithHighSalary()
                .forEach(e -> System.out.println(e.getEmployeeName()));


        System.out.println("Employees from Kolkata");

        dao.getEmployeesByCity("Kolkata")
                .forEach(e -> System.out.println(e.getEmployeeName()));


        System.out.println("Employees born after 1995");

        dao.getEmployeesBornAfter(LocalDate.of(1995,1,1))
                .forEach(e -> System.out.println(e.getEmployeeName()));


        System.out.println("Employee count by city");

        dao.countEmployeesByCity()
                .forEach(obj -> System.out.println(obj[0] + " : " + obj[1]));
    }
}
