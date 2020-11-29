package com.elar.elarbase.domain;



import com.elar.elarbase.entity.User;
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

    private User author;

    public String getNameAuthor(){
        return author != null ? author.getUsername() : "<none>";
    }
    public Device() {
    }

    public Device(String nameDevice, User user) {
        this.nameDevice = nameDevice;
        this.author = user;
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
                ", author=" + author +
                '}';
    }

//    @OneToMany(mappedBy = "project")
//    private Collection<Project> project;

//    @Column (name =  "project")
//    private Project project;


}
