package com.myprojects.javahibernatecourse.hqlrunners;

import com.myprojects.javahibernatecourse.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class NamedParametersApp {
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

        String employeeFirstName = "Marco";
        String employeeLastName = "Polo";

        currentSession.beginTransaction();

        String queryString = "select e.first_name, e.last_name, e.salary from Employee e where e.first_name='" + employeeFirstName + "' and e.last_name= '" +
                employeeLastName + "'";
        Query query = currentSession.createQuery(queryString);
        List<Object[]> list = query.getResultList();

        String namedParametersString = "select e.first_name, e.last_name, e.salary from Employee e where e.first_name=:firstname and e.last_name=:lastname";

        Query namedPArametersQuery = currentSession.createQuery(namedParametersString);
        namedPArametersQuery.setParameter("firstname", employeeFirstName);
        namedPArametersQuery.setParameter("lastname", employeeLastName);
        List<Object[]> namedParametersList = namedPArametersQuery.getResultList();

        currentSession.getTransaction().commit();

        for (Object[] values : list) {
            System.out.println("First Name: " + values[0] + ", " + "Last Name: " + values[1] + ", " + "salary: " + values[2]);
        }

        for (Object[] values : namedParametersList) {
            System.out.println("First Name: " + values[0] + ", " + "Last Name: " + values[1] + ", " + "salary: " + values[2]);
        }

        sessionFactory.close();
    }
}
