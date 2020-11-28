package com.elar.elarbase.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Table (name = "operations")
public class Operations {

    @Column (name = "numberOperation")
    private int numberOperation;

    @Column (name = "nameOperations" )
    private String nameOperations;


}
