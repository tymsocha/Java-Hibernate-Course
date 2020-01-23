package com.myprojects.javahibernatecourse.hqlrunners;

import com.myprojects.javahibernatecourse.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class WhereApp {
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

        String where = "FROM Employee WHERE first_name = 'John'";
        String whereSalary = "FROM Employee WHERE salary > 10000";

        Query query = currentSession.createQuery(whereSalary);

        List<Employee> employeeList = query.getResultList();

        currentSession.getTransaction().commit();

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        sessionFactory.close();
    }
}
