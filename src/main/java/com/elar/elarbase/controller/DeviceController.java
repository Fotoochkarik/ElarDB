package com.elar.elarbase.controller;

import com.elar.elarbase.domain.Device;
import com.elar.elarbase.domain.Project;
import com.elar.elarbase.domain.Role;
import com.elar.elarbase.entity.User;
import com.elar.elarbase.repos.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceRepo deviceRepo;


    @GetMapping
    public String deviceList(Model model){
        model.addAttribute("device", deviceRepo.findAll());
        return "deviceList";
    }

    @GetMapping("{device}")
    public String deviceEditForm(Device device, Model model ){
        model.addAttribute("device", device);
        model.addAttribute("projects", device.getProjects());
        return "deviceEdit";
    }

    @PostMapping
    public String deviceCommentsSave(
            @RequestParam String comments,
            @RequestParam("deviceId") Device device
    ){

        List<Project> projects = device.getProjects();


        for (int i = 0; i <projects.size() ; i++) {
           projects.get(i).setComments(comments);

        }
        device.setProjects(projects);


//        for (Project project : projects) {
////            if(comments != null && comments.isEmpty())
//
//            project.setComments(comments);
//            project.isDone();
//        }


        deviceRepo.save(device);
        return "redirect:/device";
    }
}
