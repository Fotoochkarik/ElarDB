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
            @RequestParam String comments0,
            @RequestParam String comments1,
            @RequestParam String comments2,
//            @RequestParam String comments,
            @RequestParam("deviceId") Device device
    ){

        List<Project> projects = device.getProjects();

//        projects.get(0).setComments(comments0);
//        projects.get(1).setComments(comments1);
//        projects.get(2).setComments(comments2);
//        projects.get(2).getTitle()




//        String cm = "comments";
//        for (int i = 0; i <projects.size() ; i++) {
//            String st =  cm + i;
//            projects.get(i).setComments(st);
//
//        }

//        String cm = "comments";
//        for (int i = 0; i <3; i++) {
//            String st = cm + i;
//
//            System.out.println(st);
//
//        }


            if (comments0 != null && !comments0.isEmpty()) {
                projects.get(0).setComments(comments0);
                //            projects.get(0).isDone();
            }

            if (comments1 != null && !comments1.isEmpty()) {
                projects.get(1).setComments(comments1);
//            projects.get(1).isDone();
            }

            if (comments2 != null && !comments2.isEmpty()) {
                projects.get(2).setComments(comments2);
//            projects.get(2).isDone();
            }


//        for (Project project : projects) {
//            if(comments != null && !comments.isEmpty())
//            project.setComments(comments);
////            project.isDone();
//        }


        deviceRepo.save(device);
        return "redirect:/device";
    }
}
