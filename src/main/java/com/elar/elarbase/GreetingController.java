package com.elar.elarbase;

import com.elar.elarbase.entity.Device;
import com.elar.elarbase.entity.Device1;
import com.elar.elarbase.repos.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private DeviceRepo deviceRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model){

        return "greeting";
    }

    @GetMapping("/main")
    public String main (Map<String,Object> model){
        Iterable<Device> devices =  deviceRepo.findAll();
        model.put("device", devices);
        return "main";
    }
    @PostMapping("/main")
    public String add (@RequestParam String nameDevice, Map<String, Object> model){
        Device device = new Device(nameDevice);
        deviceRepo.save(device);

        Iterable<Device> devices =  deviceRepo.findAll();
//        model.put("device", devices);

        return "redirect:/";
    }
    @PostMapping ("filter")
    public String filter (@RequestParam String filter, Map<String, Object> model){

       Iterable<Device> devices;

        if (filter != null && !filter.isEmpty()) {
            devices = deviceRepo.findByNameDevice(filter);
        } else {
            devices = deviceRepo.findAll();
        }
        model.put("device", devices);
        return "main";
    }

}

