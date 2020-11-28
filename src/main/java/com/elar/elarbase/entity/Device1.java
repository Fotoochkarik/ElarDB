package com.elar.elarbase.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Device1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}
