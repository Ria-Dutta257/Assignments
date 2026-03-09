package com.employee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.employee.entity.SalaryRecord;
import com.employee.util.JPAUtil;

public class SalaryDAO {

    // Insert Salary Record
    public void insertSalary(SalaryRecord salary) {

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        double net = salary.getBaseSalary() + salary.getBonus() - salary.getTax();
        salary.setNetSalary(net);

        em.persist(salary);

        em.getTransaction().commit();
        em.close();
    }


    // Update Salary
    public void updateSalary(int id, double bonus, double tax) {

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        SalaryRecord salary = em.find(SalaryRecord.class, id);

        salary.setBonus(bonus);
        salary.setTax(tax);

        double net = salary.getBaseSalary() + bonus - tax;
        salary.setNetSalary(net);

        em.getTransaction().commit();
        em.close();
    }


    // Delete Salary
    public void deleteSalary(int id) {

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        SalaryRecord salary = em.find(SalaryRecord.class, id);

        em.remove(salary);

        em.getTransaction().commit();
        em.close();
    }


    // Fetch by employeeCode
    public List<SalaryRecord> getSalaryByEmployeeCode(String code) {

        EntityManager em = JPAUtil.getEntityManager();

        TypedQuery<SalaryRecord> query = em.createQuery(
                "SELECT s FROM SalaryRecord s WHERE s.employeeCode = :code",
                SalaryRecord.class);

        query.setParameter("code", code);

        List<SalaryRecord> list = query.getResultList();

        em.close();

        return list;
    }


    // Fetch by salaryMonth
    public List<SalaryRecord> getSalaryByMonth(String month) {

        EntityManager em = JPAUtil.getEntityManager();

        TypedQuery<SalaryRecord> query = em.createQuery(
                "SELECT s FROM SalaryRecord s WHERE s.salaryMonth = :month",
                SalaryRecord.class);

        query.setParameter("month", month);

        List<SalaryRecord> list = query.getResultList();

        em.close();

        return list;
    }
}
