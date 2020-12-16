package com.elar.elarbase.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column (name = "status")
    private boolean status;

    private String mode;

    @Column(name = "comments")
    private String comments;

    private  Integer quantity;

    private Date date;

    private int counter = 0;

    public Project(String title, String mode) {
        this.title = title;
        this.status = false;
        this.mode = mode;

    }

    public Project() {
    }


    public boolean isDone(){
        this.date = new Date();
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
