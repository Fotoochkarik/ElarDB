package com.elar.elarbase.controller;

import com.elar.elarbase.domain.Device;
import com.elar.elarbase.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String filter(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Device> devices = deviceService.findByNameDevice(filter);
        model.addAttribute("device", devices);
        model.addAttribute("filter", filter);
        return "main";
    }
}

