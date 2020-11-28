package com.elar.elarbase.entity;



import javax.persistence.*;


public class SummaryDevices {
    @Id
    @Column(name = "device_id")
    private int id;


    @Column(name = "name_device")
    private String nameDevice;


    private Device device;
}
