package com.myprojects.javahibernatecourse.onetoonerelation;

import com.myprojects.javahibernatecourse.domain.Company;
import com.myprojects.javahibernatecourse.domain.CompanyDetail;
import com.myprojects.javahibernatecourse.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CascadeRemoveApp {
    public static void main(String[] args) {
        //Creating configuration object
        Configuration configuration = new Configuration();

        //Loading configuration file
        configuration.configure("hibernate.cfg.xml");

        //Loading annotations
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(CompanyDetail.class);

        //Creating SessionFactory object
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //Downloading session
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        Company company = currentSession.get(Company.class, 11);
        currentSession.remove(company);

        currentSession.getTransaction().commit();

        sessionFactory.close();
    }
}
