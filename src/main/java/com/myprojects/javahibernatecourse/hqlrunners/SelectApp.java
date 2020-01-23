package com.myprojects.javahibernatecourse.hqlrunners;

import com.myprojects.javahibernatecourse.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class SelectApp {
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

        String select = "select first_name, last_name from Employee";

        String aliasSelect = "select e.first_name, e.last_name from Employee as e";

        String mixedSelect = "select e.first_name, e.last_name from Employee e";

        Query query = currentSession.createQuery(mixedSelect);

        List<Object[]> results = query.getResultList();

        currentSession.getTransaction().commit();

        for (Object[] values : results) {
            System.out.println("First Name: " + values[0] + ", " + "Last Name: " + values[1]);
        }

        sessionFactory.close();
    }
}
