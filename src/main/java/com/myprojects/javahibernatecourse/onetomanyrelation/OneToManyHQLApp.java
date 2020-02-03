package com.myprojects.javahibernatecourse.onetomanyrelation;

import com.myprojects.javahibernatecourse.domain.Company;
import com.myprojects.javahibernatecourse.domain.CompanyDetail;
import com.myprojects.javahibernatecourse.domain.Employee;
import com.myprojects.javahibernatecourse.domain.Property;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class OneToManyHQLApp {
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

        String sevilla = "select c.name from Property p join p.company c where p.city = 'Sevilla'";
        String barcelona = "select c.name from Property p join p.company c join c.companyDetail cd where p.city = 'Barcelona' and cd.residence = 'Switzerland'";
        String fourProperties = "select c.name from Company c where size(c.propertyList) > 4 ";

        currentSession.beginTransaction();

        Query query = currentSession.createQuery(sevilla);
        Query query1 = currentSession.createQuery(barcelona);
        Query query2 = currentSession.createQuery(fourProperties);

        List<String> resultList = query.getResultList();

        List<String> resultList2 = query1.getResultList();

        List<String> resultList3 = query2.getResultList();

        currentSession.getTransaction().commit();

        for (String name : resultList) {
            System.out.println(name);
        }

        for (String name :resultList2) {
            System.out.println(name);
        }

        for (String name :resultList3) {
            System.out.println(name);
        }



        sessionFactory.close();
    }
}
