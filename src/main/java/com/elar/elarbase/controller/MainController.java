package com.elar.elarbase.controller;

import com.elar.elarbase.domain.Device;
import com.elar.elarbase.domain.Project;
import com.elar.elarbase.domain.User;
import com.elar.elarbase.repos.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.TreeMap;

@Controller

public class MainController {

    @Autowired
    private DeviceRepo deviceRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model){

        return "greeting";
    }

    @GetMapping("/main")
    public String main (@RequestParam (required = false, defaultValue = "") String filter, Model model){
        Iterable<Device> devices =  deviceRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            devices = deviceRepo.findByNameDevice(filter);
        } else {
            devices = deviceRepo.findAll();
        }
        model.addAttribute("device", devices);
        model.addAttribute("filter", filter);
        return "main";
    }
    @PostMapping("/main")
    public String add (
            @AuthenticationPrincipal User author,
            @RequestParam String nameDevice,
            @RequestParam String  titleProject1,
            @RequestParam String  titleProject2,
            @RequestParam String  titleProject3,
            @RequestParam String modeProject1,
            @RequestParam String  modeProject2,
            @RequestParam String  modeProject3,
                    Map<String, Object> model){
        Project project1 = new Project(titleProject1, modeProject1);
        Project project2 =new Project(titleProject2, modeProject2);
        Project project3 =new Project(titleProject3, modeProject3);
        Map<Long, Project> projects = new TreeMap<>();
        projects.put(1L, project1);
        projects.put(2L, project2);
        projects.put(3L, project3);
        Device device = new Device(nameDevice, author, projects);


        deviceRepo.save(device);

        Iterable<Device> devices =  deviceRepo.findAll();
//        model.put("device", devices);

        return "redirect:/";
    }



}

