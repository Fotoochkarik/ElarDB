package com.elar.elarbase.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Data
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "name_device")
    private String nameDevice;

    private User author;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id" )
//    private Map<Long, Project> projects;
    private List< Project> projects;

    public String getNameAuthor(){
        return author != null ? author.getUsername() : "<none>";
    }
    public Device() {
    }

    public Device(String nameDevice, User author, List<Project> projects) {
        this.nameDevice = nameDevice;
        this.author = author;
        this.projects = projects;
    }



    //    @OneToOne (cascade = CascadeType.ALL)
//    @JoinColumn(name = "device_id")
//    private SummaryDevices summary;

    //OneToMany Example



    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", nameDevice='" + nameDevice + '\'' +
                ", author=" + author +
                '}';
    }

//    @OneToMany(mappedBy = "project")
//    private Collection<Project> project;

//    @Column (name =  "project")
//    private Project project;


}
