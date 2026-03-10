package com.assignment.dao;

import com.assignment.entity.Address;
import com.assignment.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddressDAO {

    public Address getAddressById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Address addr = session.get(Address.class, id);

        session.close();

        return addr;
    }

    public void updateAddress(Address addr) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(addr);

        tx.commit();
        session.close();
    }

    public void deleteAddress(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Address addr = session.get(Address.class, id);

        session.delete(addr);

        tx.commit();
        session.close();
    }
}
