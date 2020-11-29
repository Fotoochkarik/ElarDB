package com.elar.elarbase.entity;

import com.elar.elarbase.bl.SessionUtil;
import com.elar.elarbase.domain.Device;
import com.elar.elarbase.domain.Project;
import com.elar.elarbase.service.DeviceService;
import com.elar.elarbase.service.ProjectService;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;


public class Task  extends SessionUtil{

    public  void initializationTask(String deviceName, int fromId, int beforeId) throws SQLException {

        openTransactionSession();            //открытие
        Session session = getSession();

        DeviceService deviceService = new DeviceService();
        Device device = new Device();
        device.setNameDevice(deviceName);

        ProjectService projectService = new ProjectService();
        ArrayList<Project> projectList = new ArrayList<Project>();

        for (int i = fromId; i < beforeId; i++) {
            projectList.add(projectService.getById(i));
        }

        device.setProjects(projectList);

        session.save(device);

        System.out.println("Task added " + deviceName);
        closeTransactionSession();         // закрытие транзакции


    }
}
