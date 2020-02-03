package com.myprojects.javahibernatecourse.onetomanyrelation;

import com.myprojects.javahibernatecourse.domain.Company;
import com.myprojects.javahibernatecourse.domain.CompanyDetail;
import com.myprojects.javahibernatecourse.domain.Employee;
import com.myprojects.javahibernatecourse.domain.Property;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class OneToManySaveApp {
    public static void main(String[] args) {
        //Creating configuration object
        Configuration configuration = new Configuration();

        //Loading configuration file
        configuration.configure("hibernate.cfg.xml");

        //Loading annotations
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(CompanyDetail.class);
        configuration.addAnnotatedClass(Property.class);

        //Creating SessionFactory object
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //Downloading session
        Session currentSession = sessionFactory.getCurrentSession();

        String getCompany = "select c from Company c where c.name='Eni'";

        currentSession.beginTransaction();

        Query query = currentSession.createQuery(getCompany);
        Company eni = (Company) query.getSingleResult();
        System.out.println(eni);

        Property property1 = new Property("Warsaw", 45);
        Property property2 = new Property("Munich", 120);
        eni.addProperty(property1);
        eni.addProperty(property2);

        currentSession.persist(property1);
        currentSession.persist(property2);

        currentSession.getTransaction().commit();


        sessionFactory.close();
    }
}
