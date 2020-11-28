package com.elar.elarbase.entity;



import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "device")

public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "name_device")
      private String nameDevice;

    public Device() {
    }

    public Device(String nameDevice) {
        this.nameDevice = nameDevice;
    }
    //    @OneToOne (cascade = CascadeType.ALL)
//    @JoinColumn(name = "device_id")
//    private SummaryDevices summary;

    //OneToMany Example

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id" )
    private List<Project> projects;

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", nameDevice='" + nameDevice + '\'' +
                ", projects=" +
                '}';
    }

//    @OneToMany(mappedBy = "project")
//    private Collection<Project> project;

//    @Column (name =  "project")
//    private Project project;


}
