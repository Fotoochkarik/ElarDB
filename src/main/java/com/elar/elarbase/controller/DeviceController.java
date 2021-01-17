package com.elar.elarbase.controller;

import com.elar.elarbase.domain.Device;
import com.elar.elarbase.domain.Project;
import com.elar.elarbase.repos.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceRepo deviceRepo;


    @GetMapping
    public String deviceList(Model model){
        model.addAttribute("device", deviceRepo.findAll());
        return "/";
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
            @RequestParam("deviceId") Device device){
        List<Project> projectsList =device.getProjects();

        for (Project project : projectsList) {
            if(!project.isStatus()){
                project.setComments(comments);
                project.isDone();
                break;
            }
        }
        deviceRepo.save(device);
        return "redirect:/device";
    }

}
