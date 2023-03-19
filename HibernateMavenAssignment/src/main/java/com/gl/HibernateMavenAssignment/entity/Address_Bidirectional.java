package com.gl.HibernateMavenAssignment.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Address_Bidirectional")
public class Address_Bidirectional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    private String city;
    private String state;
    private String country;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student_Bidirectional student_bi;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student_Bidirectional getStudent_bi() {
        return student_bi;
    }

    public void setStudent_bi(Student_Bidirectional student_bi) {
        this.student_bi = student_bi;
    }

    @Override
    public String toString() {
        return "Address_Bidirectional{" +
                "addressId=" + addressId +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", student_bi=" + student_bi +
                '}';
    }
}
