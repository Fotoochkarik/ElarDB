package com.elar.elarbase.service;


import com.elar.elarbase.bl.SessionUtil;
import com.elar.elarbase.dao.DeviceDAO;
import com.elar.elarbase.entity.Device;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;


public class DeviceService extends SessionUtil implements DeviceDAO {

//    private final SessionFactory factory;

    @Override
    public Device createDevice(Device device) throws SQLException {


        openTransactionSession(); //открытие

        Session session = getSession();  // логика транзакции
        session.save(device);           // логика транзакции

        closeTransactionSession();//закрытие

//        Session session = factory.openSession();
//        Transaction transaction = session.beginTransaction();
//
//       Device device = new Device();
//
//       device.setNameDevice(nameDevice);
//
//        session.persist(device);
//
//        transaction.commit();
//        session.close();

        return device;

    }

    @Override
    public List<Device> getAll() throws SQLException {
        return null;
    }

    @Override
    public Device getById(int id) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        Query query = session.createNativeQuery("select * from device where id = ?").addEntity(Device.class);
        query.setParameter(1, id);

        Device device = (Device) query.getSingleResult();

        closeTransactionSession();
        return device;
    }

    @Override
    public void update(Device device) throws SQLException {

    }

    @Override
    public void remove(Device device) throws SQLException {

    }


    public void printDevice(Device device){
        openTransactionSession();

        Session session = getSession();





        closeTransactionSession();
    }
}
