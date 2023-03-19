package com.gl.HibernateMavenAssignment.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projId;
    private String projName;
    private String projClient;
    @ManyToMany(mappedBy = "Projects")
    List<Employee> employees;

    public Project(){

    }
    public Project(String projName, String projClient, List<Employee> employees) {
        this.projName = projName;
        this.projClient = projClient;
        this.employees = employees;
    }

    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getProjClient() {
        return projClient;
    }

    public void setProjClient(String projClient) {
        this.projClient = projClient;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projId=" + projId +
                ", projName='" + projName + '\'' +
                ", projClient='" + projClient + '\'' +
                ", employees=" + employees +
                '}';
    }
}
