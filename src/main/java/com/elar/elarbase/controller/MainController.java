package com.elar.elarbase.controller;

import com.elar.elarbase.domain.Device;
import com.elar.elarbase.entity.User;
import com.elar.elarbase.repos.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            @RequestParam String nameDevice, Map<String, Object> model){
        Device device = new Device(nameDevice, author);
        deviceRepo.save(device);

        Iterable<Device> devices =  deviceRepo.findAll();
//        model.put("device", devices);

        return "redirect:/";
    }


}

