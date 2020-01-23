package com.myprojects.javahibernatecourse.hqlrunners;

import com.myprojects.javahibernatecourse.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class OrderByApp {
    public static void main(String[] args) {
        //Creating configuration object
        Configuration configuration = new Configuration();

        //Loading configuration file
        configuration.configure("hibernate.cfg.xml");

        //Loading annotations
        configuration.addAnnotatedClass(Employee.class);

        //Creating SessionFactory object
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //Downloading session
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        String orderBy = "select e.first_name, e.last_name from Employee e order by e.first_name";
        String orderByDesc = "select e.first_name, e.last_name from Employee e order by e.first_name desc";
        String orderByAsc = "select e.first_name, e.last_name, e.salary from Employee e order by e.salary asc";

        Query query = currentSession.createQuery(orderByAsc);

        List<Object[]> list = query.getResultList();

        currentSession.getTransaction().commit();

        for (Object[] values : list) {
            System.out.println("First Name: " + values[0] + ", " + "Last Name: " + values[1] + ", " + "salary: " + values[2]);
        }

        sessionFactory.close();
    }
}
