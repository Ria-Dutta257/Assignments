package com.assignment.dao;

import com.assignment.entity.Employee;
import com.assignment.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class EmployeeDAO {

    public void insertEmployee(Employee emp) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(emp);

        tx.commit();
        session.close();
    }

    public Employee getEmployeeById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Employee emp = session.get(Employee.class, id);

        session.close();

        return emp;
    }

    public List<Employee> getAllEmployees() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Employee> list = session.createQuery("FROM Employee", Employee.class).list();

        session.close();

        return list;
    }

    public void updateEmployee(Employee emp) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(emp);

        tx.commit();
        session.close();
    }

    public void deleteEmployee(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = session.get(Employee.class, id);

        session.delete(emp);

        tx.commit();
        session.close();
    }
    
    public List<Employee> getEmployeesWithHighSalary() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        String jpql = "FROM Employee e WHERE e.salary > 15000";

        List<Employee> list = session.createQuery(jpql, Employee.class).getResultList();

        session.close();

        return list;
    }
    
    public List<Employee> getEmployeesByCity(String city) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        String jpql = "FROM Employee e WHERE e.address.city = :city";

        List<Employee> list = session.createQuery(jpql, Employee.class)
                .setParameter("city", city)
                .getResultList();

        session.close();

        return list;
    }
    
    public List<Employee> getEmployeesBornAfter(LocalDate date) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        String jpql = "FROM Employee e WHERE e.dateOfBirth > :date";

        List<Employee> list = session.createQuery(jpql, Employee.class)
                .setParameter("date", date)
                .getResultList();

        session.close();

        return list;
    }
    
    public List<Object[]> countEmployeesByCity() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        String jpql = "SELECT e.address.city, COUNT(e) FROM Employee e GROUP BY e.address.city";

        List<Object[]> list = session.createQuery(jpql).getResultList();

        session.close();

        return list;
    }
}
