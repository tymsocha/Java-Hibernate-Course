package com.myprojects.javahibernatecourse.hqlrunners;

import com.myprojects.javahibernatecourse.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UpdateApp {
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

        Long idEmployee = 45L;
        int salary = 15000;

        String update = "update Employee e set e.salary=:salary where e.id_employee=:idEmployee";
        Query query = currentSession.createQuery(update);
        query.setParameter("salary", salary);
        query.setParameter("idEmployee", idEmployee);
        query.executeUpdate();

        currentSession.getTransaction().commit();

        sessionFactory.close();
    }
}
