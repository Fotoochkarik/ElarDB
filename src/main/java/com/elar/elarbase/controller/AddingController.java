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
@RequestMapping("/add")
public class AddingController {

    @Autowired
    private DeviceRepo deviceRepo;

    @GetMapping
    public String addDevice(Device device, Model model){
        model.addAttribute("device", deviceRepo.findAll());
        model.addAttribute("projects", device.getProjects());
        return "addProject";
    }
//    @PostMapping
////    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String addForm(
//            @AuthenticationPrincipal User author,
//            @RequestParam String nameD,
////            @RequestParam String  titleProject,
////            @RequestParam String modeProject,
//            Map<String, Object> model){
//
//        Device device = new Device();
//        List<Project> projects = new ArrayList<>();
////        projects.add( new Project(titleProject, modeProject));
//        device.setNameDevice(nameD);
//        device.setAuthor(author);
//        device.setProjects(projects);
//
//        deviceRepo.save(device);
//
//        return "addProject";
//    }
//    @PostMapping("/add")
//    public String addForm(@RequestParam("deviceId") Device device,
//            @RequestParam String  titleProject,
//            @RequestParam String modeProject
//            ){
//        List<Project> projects = device.getProjects();
//        projects.add( new Project(titleProject, modeProject));
//        device.setProjects(projects);
//        deviceRepo.save(device);
//        return "redirect:/addProject";
//    }

        @GetMapping("{device}")
    public String deviceEditForm(Device device, Model model){
        model.addAttribute("device", device);
            return "addProject";

    }
}
