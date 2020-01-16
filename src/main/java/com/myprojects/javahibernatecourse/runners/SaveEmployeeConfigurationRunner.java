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
public class SaveEmployeeConfigurationRunner implements CommandLineRunner {
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
//        Employee employee = new Employee(1L, "John", "Smith", 2500);
//
//        //Beginning transaction
//        currentSession.beginTransaction();
//
//        //Saving employees
//        currentSession.save(employee);
//
//        //Ending transaction
//        currentSession.getTransaction().commit();
//
//        //Closing sessionFactory object
//        sessionFactory.close();
    }
}
