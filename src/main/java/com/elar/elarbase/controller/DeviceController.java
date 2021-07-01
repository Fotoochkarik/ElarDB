package com.elar.elarbase.controller;

import com.elar.elarbase.domain.Device;
import com.elar.elarbase.domain.User;
import com.elar.elarbase.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping
    public String add(
            @AuthenticationPrincipal User author,
            @RequestParam String nameDevice
    ) {
        Integer id = deviceService.save(author, nameDevice).getId();
        return "redirect:/device/add/" + id;
    }

    @GetMapping("/add")
    public String redirectMain() {
        return "redirect:/main";
    }

    @GetMapping("{device}")
    public String addComent(Device device, Model model) {
        model.addAttribute("device", device);
        model.addAttribute("projects", device.getProjects());
        return "deviceEdit";
    }

    @PostMapping("/comment")
    public String saveComment(
            @RequestParam String comments,
            @RequestParam("deviceId") Device device
    ) {
        deviceService.saveComment(device, comments);
        return "redirect:/main";
    }

    @PostMapping("/add")
    public String addForm(
            @RequestParam("deviceId") Device device,
            @RequestParam String titleProject,
            @RequestParam String modeProject
    ) {
        deviceService.addProjectToDevise(device, titleProject, modeProject);
        return "redirect:/device/add/" + device.getId();
    }

    @GetMapping("/add/{device}")
    public String redirectToAddProject(Device device, Model model) {
        model.addAttribute("device", device);
        return "addProject";
    }
}
