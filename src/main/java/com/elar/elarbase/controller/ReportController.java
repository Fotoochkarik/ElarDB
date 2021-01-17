package com.elar.elarbase.controller;

import com.elar.elarbase.domain.Device;
import com.elar.elarbase.domain.Project;
import com.elar.elarbase.repos.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    DeviceRepo deviceRepo;

    @GetMapping
    public String reportDevice(Model model){
        model.addAttribute("device",deviceRepo.findAll());
        return "reportList";
    }
    @GetMapping("{device}")
    public String deviceEditForm(Device device, Model model ){
        model.addAttribute("device", device);
        model.addAttribute("projects", device.getProjects().stream()
                .sorted(Comparator.comparing(Project::getCounter))
                .collect(Collectors.toList())
        );
        return "report";
    }
}
