package com.gl.HibernateMavenAssignment;

import com.gl.HibernateMavenAssignment.config.HibernateConfig;
import com.gl.HibernateMavenAssignment.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import jakarta.persistence.Query;

import java.util.List;

public class AppManyToManyHQL {
    private static SessionFactory factory = HibernateConfig.getSessionFactory();
    public static void main(String[] args) {
        System.out.println("Printing Employee Names using Project ID:");
        fetchEmployees(1);

        System.out.println("Printing Project Names using Employee ID:");
        fetchProjects(1);
    }
    public static void fetchEmployees(int projId){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("SELECT e.name FROM Employee e JOIN e.projects p WHERE p.projId = :projectId");
        query.setParameter("projectId",projId);
        List<String> employeeNames = query.getResultList();

        for(String empNames:employeeNames){
            System.out.println(empNames);
        }

        tx.commit();
        session.close();
    }
    public static void fetchProjects(int empId){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("SELECT p.projName FROM Project p JOIN p.employees e WHERE e.empId = :employeeId");
        query.setParameter("employeeId",empId);
        List<String> projectNames = query.getResultList();

        for(String projNames:projectNames){
            System.out.println(projNames);
        }

        tx.commit();
        session.close();
    }
}
