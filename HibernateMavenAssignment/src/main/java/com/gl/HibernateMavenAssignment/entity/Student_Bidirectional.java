package com.gl.HibernateMavenAssignment.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Student_Bidirectional")
public class Student_Bidirectional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String name;
    private String email;
    @OneToOne(mappedBy = "Student_Bidirectional",cascade = CascadeType.ALL)
    private Address_Bidirectional address_bi;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address_Bidirectional getAddress_bi() {
        return address_bi;
    }

    public void setAddress_bi(Address_Bidirectional address_bi) {
        this.address_bi = address_bi;
    }

    @Override
    public String toString() {
        return "Student_Bidirectional{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address_bi=" + address_bi +
                '}';
    }
}
