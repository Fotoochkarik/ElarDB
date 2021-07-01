package com.elar.elarbase.service;

import com.elar.elarbase.domain.Device;
import com.elar.elarbase.domain.Project;
import com.elar.elarbase.domain.User;
import com.elar.elarbase.repos.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepo deviceRepo;

    public Iterable<Device> findAll() {
        return deviceRepo.findAll();
    }

    public Iterable<Device> findByNameDevice(String filter) {
        if (filter != null && !filter.isEmpty()) {
            return deviceRepo.findByNameDevice(filter);
        }
        return deviceRepo.findAll();
    }

    public Device save(User author, String nameDevice) {
        Device device = new Device();
        device.setNameDevice(nameDevice);
        device.setAuthor(author);
        deviceRepo.save(device);
        return device;
    }

    public void addProjectToDevise(Device device, String titleProject, String modeProject) {
        List<Project> projects = device.getProjects();
        projects.add(new Project(titleProject, modeProject));
        for (int i = 0; i < projects.size(); i++) {
//            if(projects.get(i).getCounter() == 0){
            projects.get(i).setCounter(i + 1);
//            }
        }
        device.setProjects(projects);
        deviceRepo.save(device);

    }

    public void saveComment(Device device, String comments) {
        List<Project> projectsList = device.getProjects();
        for (Project project : projectsList) {
            if (!project.isStatus()) {
                project.setComments(comments);
                project.isDone();
                break;
            }
        }
        deviceRepo.save(device);
    }
}
