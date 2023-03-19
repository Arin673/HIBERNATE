package com.gl.HibernateMavenAssignment;

import com.gl.HibernateMavenAssignment.config.HibernateConfig;
import com.gl.HibernateMavenAssignment.entity.Course;
import com.gl.HibernateMavenAssignment.entity.Student_O2M;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AppOneToManyBidirectional {
    private static SessionFactory factory = HibernateConfig.getSessionFactory();
    public static void main(String[] args) {

        Student_O2M student = new Student_O2M();
        student.setName("Senade");
        student.setEmail("xyz@gmail.com");

        List<Course> courses = new ArrayList<Course>();
        Course course = new Course();
        course.setCourseName("Machine_Learning_Engineer");
        course.setCoursePrice(200000);
        course.setStudent_o2m(student);

        courses.add(course);

        System.out.println("Insertion of data in both the tables in database:");
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        for(Course c:courses){
            session.persist(c);
        }
        session.persist(student);
        tx.commit();
        session.close();

        System.out.println("Removing Course without affecting Student:");
        deleteCourse(1);
    }

    public static void deleteCourse(int courseId){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Course course = session.get(Course.class,courseId);
        session.remove(course);
        tx.commit();
        session.close();
    }


}
