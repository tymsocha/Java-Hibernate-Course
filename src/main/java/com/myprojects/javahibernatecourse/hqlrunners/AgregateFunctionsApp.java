package com.myprojects.javahibernatecourse.hqlrunners;

import com.myprojects.javahibernatecourse.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class AgregateFunctionsApp {
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

        String avg = "select avg(e.salary) from Employee e";
        String sum = "select sum(e.salary) from Employee e";
        String min = "select min(e.salary) from Employee e";
        String max = "select max(e.salary) from Employee e";
        String count = "select count(e) from Employee e";

        Query avgQuery = currentSession.createQuery(avg);
        Query sumQuery = currentSession.createQuery(sum);
        Query minQuery = currentSession.createQuery(min);
        Query maxQuery = currentSession.createQuery(max);
        Query countQuery = currentSession.createQuery(count);

        Double avgResult = (Double) avgQuery.getSingleResult();
        Long sumResult = (Long) sumQuery.getSingleResult();
        Integer minResult = (Integer) minQuery.getSingleResult();
        Integer maxResult = (Integer) maxQuery.getSingleResult();
        Long countResult = (Long) countQuery.getSingleResult();

        currentSession.getTransaction().commit();

        System.out.println("Average salary is " + avgResult);
        System.out.println("Sum of all salaries is " + sumResult);
        System.out.println("Minimum salary is " + minResult);
        System.out.println("Maximum salary is " + maxResult);
        System.out.println("Count of all employees is " + countResult);

        sessionFactory.close();
    }
}
