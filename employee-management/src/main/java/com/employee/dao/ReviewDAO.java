package com.employee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.employee.entity.PerformanceReview;
import com.employee.util.JPAUtil;

public class ReviewDAO {

    // Insert Review
    public void insertReview(PerformanceReview review) {

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        em.persist(review);

        em.getTransaction().commit();

        em.close();
    }


    // Update Review
    public void updateReview(int id, int rating, String comments) {

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        PerformanceReview review = em.find(PerformanceReview.class, id);

        review.setRating(rating);
        review.setComments(comments);

        em.getTransaction().commit();

        em.close();
    }


    // Delete Review
    public void deleteReview(int id) {

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        PerformanceReview review = em.find(PerformanceReview.class, id);

        em.remove(review);

        em.getTransaction().commit();

        em.close();
    }


    // Fetch reviews by employeeCode
    public List<PerformanceReview> getReviewsByEmployee(String code) {

        EntityManager em = JPAUtil.getEntityManager();

        TypedQuery<PerformanceReview> query = em.createQuery(
                "SELECT r FROM PerformanceReview r WHERE r.employeeCode = :code",
                PerformanceReview.class);

        query.setParameter("code", code);

        List<PerformanceReview> list = query.getResultList();

        em.close();

        return list;
    }
}
