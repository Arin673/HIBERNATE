package com.gl.HibernateMavenAssignment;

import com.gl.HibernateMavenAssignment.config.HibernateConfig;
import com.gl.HibernateMavenAssignment.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

// import java.util.ArrayList;
import java.util.List;

public class App 
{
    private static SessionFactory factory = HibernateConfig.getSessionFactory();
    public static void main( String[] args )
    {
        Teacher t1 = new Teacher();
        t1.setFirstName("John");
        t1.setLastName("Raddison");
        t1.setEmail("abc@gmail.com");
        insertTeacher(t1);

        t1 = new Teacher();
        t1.setFirstName("Suteesh");
        t1.setLastName("Michaels");
        t1.setEmail("def@gmail.com");
        insertTeacher(t1);

        t1 = new Teacher();
        t1.setFirstName("Peter");
        t1.setLastName("Dury");
        t1.setEmail("xyz@gmail.com");
        insertTeacher(t1);

        t1 = new Teacher();
        t1.setFirstName("Ethan");
        t1.setLastName("Hawk");
        t1.setEmail("maven@gmail.com");
        //Insert Teacher data
        insertTeacher(t1);

        //Update Data
        t1.setFirstName("John");
        t1.setLastName("Cybala");
        updateTeacher(t1);

        Teacher readTeacher = readTeacher(t1.getId());
        System.out.println("Read Teacher: " + readTeacher.toString());

        deleteTeacher(t1.getId());

        System.out.println("Get all Queries:");
        getAllTeachers();
    }
    public static void insertTeacher(Teacher teacher){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(teacher);
        tx.commit();
        session.close();

        System.out.println("Teacher's Data Inserted"+teacher.toString());
    }
    public static void updateTeacher(Teacher teacher){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.merge(teacher);
        tx.commit();
        session.close();

        System.out.println("Teacher's Data Updated"+teacher.toString());
    }
    public static void deleteTeacher(int tid)
    {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Teacher teacher = session.get(Teacher.class,tid);
        session.remove(teacher);
        tx.commit();
        session.close();

        System.out.println("Deleted Teacher with Id"+tid);
    }

    public static Teacher readTeacher(int tid){
        Session session = factory.openSession();
        Teacher teacher = session.get(Teacher.class,tid);
        session.close();

        return teacher;
    }
    public static void getAllTeachers(){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        List<Teacher> teachers = session.createQuery("from teacher", Teacher.class).getResultList();
        for(Teacher teacher : teachers){
            System.out.println(teacher.toString());
        }
    }
}
