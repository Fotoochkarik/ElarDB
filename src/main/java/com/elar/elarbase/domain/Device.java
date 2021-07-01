package com.elar.elarbase.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_device")
    private String nameDevice;

    private User author;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private List<Project> projects;

    public String getNameAuthor() {
        return author != null ? author.getUsername() : "<none>";
    }

    public Device() {
    }

    public Device(String nameDevice, User author, List<Project> projects) {
        this.nameDevice = nameDevice;
        this.author = author;
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameDevice() {
        return nameDevice;
    }

    public void setNameDevice(String nameDevice) {
        this.nameDevice = nameDevice;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", nameDevice='" + nameDevice + '\'' +
                ", author=" + author +
                '}';
    }
}
