package com.myprojects.javahibernatecourse.onetoonerelation;

import com.myprojects.javahibernatecourse.domain.Company;
import com.myprojects.javahibernatecourse.domain.CompanyDetail;
import com.myprojects.javahibernatecourse.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BidirectionalApp {
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

//        Company company = new Company("PZU", 1500);
//        CompanyDetail companyDetail = new CompanyDetail("Poland", 170);
//        companyDetail.setCompany(company);
//        company.setCompanyDetail(companyDetail);

        currentSession.beginTransaction();

//        currentSession.persist(companyDetail);
        CompanyDetail detail = currentSession.get(CompanyDetail.class, 10);
        currentSession.remove(detail);

        currentSession.getTransaction().commit();

//        System.out.println(detail.getCompany());

        sessionFactory.close();
    }
}
