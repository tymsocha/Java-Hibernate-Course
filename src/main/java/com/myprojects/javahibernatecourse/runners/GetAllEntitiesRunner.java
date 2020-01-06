package com.myprojects.javahibernatecourse.runners;

import com.myprojects.javahibernatecourse.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("singleton")
public class GetAllEntitiesRunner implements CommandLineRunner {
    @Override
    public void run(String... args) {
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

        //Creating object

        //Beginning transaction
        currentSession.beginTransaction();

        List<Employee> employees = currentSession.createQuery("FROM Employee", Employee.class).getResultList();

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        //Ending transaction
        currentSession.getTransaction().commit();


        //Closing sessionFactory object
        sessionFactory.close();
    }
}
