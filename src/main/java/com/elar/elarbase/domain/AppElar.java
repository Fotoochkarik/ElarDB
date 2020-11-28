package com.elar.elarbase.domain;


import com.elar.elarbase.bl.HibernateUtil;
import com.elar.elarbase.entity.Device;
import com.elar.elarbase.entity.Project;
import com.elar.elarbase.entity.SummaryDevices;

import org.hibernate.Session;
import com.elar.elarbase.service.DeviceService;
import com.elar.elarbase.service.ProjectService;
import com.elar.elarbase.service.TaskService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppElar {
    public static void main(String[] args) throws SQLException, IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

//        DeviceDAO deviceDAO = new DeviceService(HibernateUtils.getSessionFactory());

        DeviceService deviceService = new DeviceService();
        ProjectService projectService = new ProjectService();
        TaskService taskService = new TaskService();

        SummaryDevices summaryDevices = new SummaryDevices();
        List <Project> projectList =new ArrayList<>();

//
//        projectList.add(new Project("Операция 1"));
//        projectList.add(new Project("Операция 2"));
//        projectList.add(new Project("Операция 3"));
//        projectList.add(new Project("Операция 4"));
//        projectList.add(new Project("Операция 5"));
//
//
//        taskService.addTask("Партия 6", projectList);


        taskService.printTask("Партия 2");

//        for (int i = 0; i <25 ; i++) {
//            Project project  = new Project();
//            project.setTitle("Операция " + i);
//
//            session.save(project);
//        }

//        Task task = new Task();
//        task.initializationTask("Партия 1243", 26, 35);


        System.out.println(deviceService.getById(2) + " " );


        Device newDevice = deviceService.getById(2);



        List<Project> list = newDevice.getProjects();


//        System.out.println(list.get(0));




//        taskService.printTask(newDevice);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Device device1 = new Device();


//        for (int i = 0; i <5 ; i++) {
//          projectList.add(projectService.getById(10 + i));
//        }
//        device1.setProjects(projectList);

//        session.save(device1);



//        session.save(Task.initializationTask(device1, projectList.get(2)));














//        System.out.println("Введите название партии: ");
//
//        device1.setNameDevice(reader.readLine());

//        deviceService.createDevice(device1);

//        System.out.println("Введите номер операции: ");
//
//        operations1.setNumberOperation(Integer.parseInt(reader.readLine()));

//        System.out.println("Введите название операции: ");
//
//        project.setTitle(reader.readLine());
//        project.setStatus(false);


//        device1.setProjects(projectService.getAll());


//        operations1.setNameOperations(reader.readLine());

//        session.save(device1);
//        session.save(project);


        session.getTransaction().commit();
        HibernateUtil.shutdown();


    }
}
