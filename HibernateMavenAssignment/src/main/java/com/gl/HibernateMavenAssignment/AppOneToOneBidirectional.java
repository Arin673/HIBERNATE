package com.gl.HibernateMavenAssignment;

import com.gl.HibernateMavenAssignment.config.HibernateConfig;
import com.gl.HibernateMavenAssignment.entity.Address_Bidirectional;
import com.gl.HibernateMavenAssignment.entity.Student_Bidirectional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AppOneToOneBidirectional {
    private static SessionFactory factory = HibernateConfig.getSessionFactory();
    public static void main(String[] args) {
        Student_Bidirectional student = new Student_Bidirectional();
        student.setName("Jose");
        student.setEmail("abc@gmail.com");

        Address_Bidirectional address = new Address_Bidirectional();
        address.setCity("Gurugram");
        address.setState("Haryana");
        address.setCountry("India");

        student.setAddress_bi(address);
        address.setStudent_bi(student);

        System.out.println("Inserting Address as well as Student Data:");
        insertStudent(student);
        System.out.println("Deleting Student details using Address details:");
        deleteStudent(2);
    }
    public static void insertStudent(Student_Bidirectional student){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(student);
        tx.commit();
        session.close();

        System.out.println("Insert Student"+student.toString());
    }
    public static void deleteStudent(int addressId){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Address_Bidirectional address = session.find(Address_Bidirectional.class,addressId);
        Student_Bidirectional student = address.getStudent_bi();
        session.remove(student);

        tx.commit();
        session.close();

        System.out.println("Deleted Student Details"+student.toString());
    }
}
