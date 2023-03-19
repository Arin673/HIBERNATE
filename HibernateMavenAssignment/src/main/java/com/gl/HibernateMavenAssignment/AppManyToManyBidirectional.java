package com.gl.HibernateMavenAssignment;

import com.gl.HibernateMavenAssignment.config.HibernateConfig;
import com.gl.HibernateMavenAssignment.entity.Employee;
import com.gl.HibernateMavenAssignment.entity.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AppManyToManyBidirectional {
    private static SessionFactory factory = HibernateConfig.getSessionFactory();
    public static void main(String[] args) {

        Employee e1 = new Employee();
        e1.setName("Ethan Hawk");
        e1.setEmail("ethan@gmail.com");

        Employee e2 = new Employee();
        e2.setName("Jack Sparrow");
        e2.setEmail("jack@email.com");

        Project p1 = new Project();
        p1.setProjName("Jack reacher");
        p1.setProjClient("Rockstar");

        Project p2 = new Project();
        p2.setProjName("POTC");
        p2.setProjClient("Tencent");

        List<Employee> employees = new ArrayList<Employee>();
        List<Project> projects = new ArrayList<Project>();
        System.out.println("Inserting data to employees table:");
        employees.add(e1);
        employees.add(e2);

        p1.setEmployees(employees);
        p2.setEmployees(employees);

        System.out.println("Inserting data to projects table:");
        projects.add(p1);
        projects.add(p2);

        e1.setProjects(projects);
        e2.setProjects(projects);

        System.out.println("Saving Employees and Projects:");
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(e1);
        session.persist(e2);

        tx.commit();
        session.close();
    }
}
