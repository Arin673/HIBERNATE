package com.gl.HibernateMavenAssignment;

import com.gl.HibernateMavenAssignment.config.HibernateConfig;
import com.gl.HibernateMavenAssignment.entity.Address_Bidirectional;
import com.gl.HibernateMavenAssignment.entity.Student_Bidirectional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AppOneToOneBidirectionalHQL {
    private static SessionFactory factory = HibernateConfig.getSessionFactory();

    public static void main(String[] args) {

        Session session = factory.openSession();
        int addressId = 1;
        Address_Bidirectional address= session.find(Address_Bidirectional.class,addressId);
        if(address!=null){
            Student_Bidirectional student = address.getStudent_bi();
            System.out.println(student);
        }
        else{
            System.out.println("No Address Found!");
        }
    }
}
