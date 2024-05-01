package com.tuling.test;

import com.google.gson.Gson;
import com.tuling.pojo.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class HibernateTest {

    // https://docs.jboss.org/hibernate/orm/5.5/userguide/html_single/Hibernate_User_Guide.html#hql

    private SessionFactory sf;

    @Before
    public void init() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("/hibernate.cfg.xml").build();
        sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    @Test
    public void testCreate() {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            Customer customer = new Customer();
            customer.setCustName("徐庶55");
            session.save(customer);
            transaction.commit();
        }
    }

    @Test
    public void testFind() {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            Customer customer = session.find(Customer.class, 1L);
            System.out.println("--------------------------");
            System.out.println(new Gson().toJson(customer));
            transaction.commit();
        }
    }

    @Test
    public void testLoad() {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            Customer customer = session.load(Customer.class, 1L);
            System.out.println("--------------------------");
            System.out.println(customer);
            transaction.commit();
        }
    }

    @Test
    public void testHQL_All() {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "FROM Customer";
            List<Customer> resultList = session.createQuery(hql, Customer.class).getResultList();
            System.out.println(new Gson().toJson(resultList));
            transaction.commit();
        }
    }

    @Test
    public void testHQL() {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "from Customer where custId = :id";
            List<Customer> resultList = session.createQuery(hql, Customer.class).setParameter("id", 1L).getResultList();
            System.out.println(new Gson().toJson(resultList));
            transaction.commit();
        }
    }

    @Test
    public void testUpdate() {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            Customer customer = new Customer();
            customer.setCustId(1L);
            customer.setCustName("徐庶123");
            session.saveOrUpdate(customer);
            transaction.commit();
        }
    }

    @Test
    public void testDelete() {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            Customer customer = new Customer();
            customer.setCustId(2L);
            session.remove(customer);
            transaction.commit();
        }
    }

}
