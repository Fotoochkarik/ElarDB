package com.elar.elarbase.dao;

import com.elar.elarbase.entity.Device;

import java.sql.SQLException;
import java.util.List;

public interface DeviceDAO {

    //create
    Device createDevice (Device device) throws SQLException;

    //read
    List<Device> getAll() throws SQLException;

    Device getById (int id) throws SQLException;

    //update
    void update (Device device) throws SQLException;

    //delete
    void remove(Device device) throws SQLException;


}
