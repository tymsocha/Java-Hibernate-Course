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
public class UpdateDetachedEntityRunner implements CommandLineRunner {
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
//        currentSession.beginTransaction();
//        Employee employee = currentSession.get(Employee.class, 30L);
//        currentSession.getTransaction().commit();
//
//        System.out.println("Employee data: " + employee);
//
//        employee.setFirst_name("Marco");
//        employee.setLast_name("Polo");
//        employee.setSalary(41253);
//
//        currentSession = sessionFactory.getCurrentSession();
//        currentSession.beginTransaction();
//        currentSession.update(employee);
//        currentSession.getTransaction().commit();
//
//        System.out.println(employee);
//
//        //Closing sessionFactory object
//        sessionFactory.close();
    }
}
