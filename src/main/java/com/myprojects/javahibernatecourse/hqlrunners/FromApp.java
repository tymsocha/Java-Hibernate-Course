package com.myprojects.javahibernatecourse.hqlrunners;

import com.myprojects.javahibernatecourse.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FromApp  {
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

        String from = "FROM Employee";

        Query query = currentSession.createQuery(from);

        List<Employee> list = query.getResultList();

        currentSession.getTransaction().commit();

        for (Employee employee : list) {
            System.out.println(employee);
        }

        sessionFactory.close();
    }
}
