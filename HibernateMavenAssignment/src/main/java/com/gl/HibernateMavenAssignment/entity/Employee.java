package com.gl.HibernateMavenAssignment.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String name;
    private String email;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Employee_Project",
            joinColumns = {@JoinColumn(name = "employeeId")},
            inverseJoinColumns = {@JoinColumn(name = "ProjectId")}
    )
    private List<Project> projects;

    public Employee() {
    }
    public Employee(String name, String email, List<Project> projects) {
        this.name = name;
        this.email = email;
        this.projects = projects;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
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

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", projects=" + projects +
                '}';
    }
}
