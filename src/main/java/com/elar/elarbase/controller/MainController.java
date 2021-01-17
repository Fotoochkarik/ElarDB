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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
            Map<String, Object> model
    ){
        Device device = new Device();
        device.setNameDevice(nameDevice);
        device.setAuthor(author);

        deviceRepo.save(device);
        Integer id = device.getId();
        Iterable<Device> devices =  deviceRepo.findAll();
//        model.put("device", devices);
        return "redirect:/add/" + id;
    }
//    @PostMapping("/add")
//    public String addForm(
//            @AuthenticationPrincipal User author,
//            @RequestParam String nameD,
//            @RequestParam String  titleProject,
//            @RequestParam String modeProject,
//            Map<String, Object> model){
//
//        Device device = new Device();
//        List<Project> projects = new ArrayList<>();
//        projects.add( new Project(titleProject, modeProject));
//        device.setNameDevice(nameD);
//        device.setAuthor(author);
////        device.setProjects(projects);
//
//        deviceRepo.save(device);
//
//        return "add-project";
//    }
//    @GetMapping("/add")
//    @RequestMapping(value = "/add", method = RequestMethod.GET)
//    public String deviceList(Model model){
//
//        return "add-form";
//    }

//    @GetMapping("{device}")
//    public String deviceEditForm(Device device, Model model ){
//        model.addAttribute("device", device);
//        return "add-project";
//    }
    @PostMapping("/add")
    public String addForm(
            @RequestParam("deviceId") Device device,
            @RequestParam String  titleProject,
            @RequestParam String modeProject
    ){
        Integer id = device.getId();
        List<Project> projects = device.getProjects();
        projects.add( new Project(titleProject, modeProject));
        for (int i = 0; i < projects.size(); i++) {
//            if(projects.get(i).getCounter() == 0){
                projects.get(i).setCounter(i+1);
//            }
        }
        device.setProjects(projects);
        deviceRepo.save(device);

        return "redirect:/add/" + id;
    }


}

