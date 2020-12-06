package com.elar.elarbase.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;

    @Column (name = "status")
    private boolean status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = ("device_id"))
    private Device device;

    public Project(String title) {
        this.title = title;
        this.status = false;
    }

    public Project() {
    }

    public boolean isDone(){
        return this.status = true;
    }


//    @ManyToMany(mappedBy = "projects")
//    private Set<Employee> employees;

    //OneToMany Example


//    private EmployeeEntity employee;
//    @ManyToOne
//    @JoinColumn(name = "employee_id", referencedColumnName = "id")
//    public EmployeeEntity getEmployee() {
//        return this.employee;
//    }




//    public Set<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(Set<Employee> employees) {
//        this.employees = employees;
//    }


}
