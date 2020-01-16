package com.myprojects.javahibernatecourse.runners;

import com.myprojects.javahibernatecourse.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class PrimaryKeyIdentityRunner implements CommandLineRunner {
    @Override
    public void run(String... args) {
//        //Creating configuration object
//        Configuration configuration = new Configuration();
//
//        //Loading configuration file
//        configuration.configure("hibernate.cfg.xml");
//
//        //Loading annotations
//        configuration.addAnnotatedClass(Employee.class);
//
//        //Creating SessionFactory object
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//
//        //Downloading session
//        Session currentSession = sessionFactory.getCurrentSession();
//
//        //Creating object
//        Employee employee = new Employee();
//        employee.setFirst_name("Johnny");
//        employee.setLast_name("Smis");
//        employee.setSalary(3000);
//
//        Employee employee2 = new Employee();
//        employee2.setFirst_name("Jack");
//        employee2.setLast_name("Sparrow");
//        employee2.setSalary(6000);
//
//        Employee employee3 = new Employee();
//        employee3.setFirst_name("Nigel");
//        employee3.setLast_name("Anderson");
//        employee3.setSalary(2000);
//
//        Employee employee4 = new Employee();
//        employee4.setFirst_name("Scarlett");
//        employee4.setLast_name("Witch");
//        employee4.setSalary(10000);
//
//        //Beginning transaction
//        currentSession.beginTransaction();
//
//        //Saving four employees
//        currentSession.save(employee);
//        currentSession.save(employee2);
//        currentSession.save(employee3);
//        currentSession.save(employee4);
//
//        //Ending transaction
//        currentSession.getTransaction().commit();
//
//        //Closing sessionFactory object
//        sessionFactory.close();
    }
}
