package com.employee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.employee.entity.Employee;
import com.employee.util.JPAUtil;

public class EmployeeDAO {

    // Insert Employee
    public void insertEmployee(Employee emp) {

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();

        em.close();
    }


    // Update Employee using employeeCode
    public void updateEmployee(String code, String name, String email,
                               String designation, String department) {

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        TypedQuery<Employee> query = em.createQuery(
                "SELECT e FROM Employee e WHERE e.employeeCode = :code",
                Employee.class);

        query.setParameter("code", code);

        Employee emp = query.getSingleResult();

        emp.setName(name);
        emp.setEmail(email);
        emp.setDesignation(designation);
        emp.setDepartment(department);

        em.getTransaction().commit();

        em.close();
    }


    // Soft Delete Employee
    public void softDeleteEmployee(String code) {

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        TypedQuery<Employee> query = em.createQuery(
                "SELECT e FROM Employee e WHERE e.employeeCode = :code",
                Employee.class);

        query.setParameter("code", code);

        Employee emp = query.getSingleResult();

        emp.setActive(false);

        em.getTransaction().commit();

        em.close();
    }


    // Fetch Employee by ID
    public Employee getEmployeeById(int id) {

        EntityManager em = JPAUtil.getEntityManager();

        Employee emp = em.find(Employee.class, id);

        em.close();

        return emp;
    }


    // Fetch Employee by employeeCode
    public Employee getEmployeeByCode(String code) {

        EntityManager em = JPAUtil.getEntityManager();

        TypedQuery<Employee> query = em.createQuery(
                "SELECT e FROM Employee e WHERE e.employeeCode = :code",
                Employee.class);

        query.setParameter("code", code);

        Employee emp = query.getSingleResult();

        em.close();

        return emp;
    }


    // Fetch All Active Employees using JPQL
    public List<Employee> getAllActiveEmployees() {

        EntityManager em = JPAUtil.getEntityManager();

        TypedQuery<Employee> query = em.createQuery(
                "SELECT e FROM Employee e WHERE e.active = true",
                Employee.class);

        List<Employee> list = query.getResultList();

        em.close();

        return list;
    }
}