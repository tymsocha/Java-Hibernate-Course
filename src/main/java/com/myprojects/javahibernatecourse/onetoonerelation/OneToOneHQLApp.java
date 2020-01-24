package com.myprojects.javahibernatecourse.onetoonerelation;

import com.myprojects.javahibernatecourse.domain.Company;
import com.myprojects.javahibernatecourse.domain.CompanyDetail;
import com.myprojects.javahibernatecourse.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class OneToOneHQLApp {
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

//        String select = "select c from Company c";
//        Query query = currentSession.createQuery(select);
//        List<Company> list = query.getResultList();

//        String selectItaly = "select c from Company c join c.companyDetail cd where cd.residence=:residence";
//        String italy = "Italy";
//        Query query = currentSession.createQuery(selectItaly);
//        query.setParameter("residence", italy);
//        List<Company> list = query.getResultList();

//        String selectPolandSum = "select sum(c.value) from Company c join c.companyDetail cd where cd.residence=:residence";
//        String poland = "Poland";
//        Query query = currentSession.createQuery(selectPolandSum);
//        query.setParameter("residence", poland);
//        List<Long> list = query.getResultList();

        String orderBy = "select c.name from CompanyDetail cd join cd.company c where cd.employeeNumber < 35000 order by c.value";
        Query query = currentSession.createQuery(orderBy);
        List<String> list = query.getResultList();

        currentSession.getTransaction().commit();

//        for (Company company : list) {
//            System.out.println(company + ", " + company.getCompanyDetail());
//        }

//        for (Long l : list) {
//            System.out.println("**********************" + l);
//        }

        for (String string : list) {
            System.out.println(string);
        }

        sessionFactory.close();
    }
}
