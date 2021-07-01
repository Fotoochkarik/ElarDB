package com.elar.elarbase.controller;

import com.elar.elarbase.domain.Role;
import com.elar.elarbase.domain.User;
import com.elar.elarbase.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
//        User userFromDb = userRepo.findByLogin(user.getUsername());
//        if (userFromDb != null) {
//            model.put("message", "User exist!" );
//            return "registration";
//        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "login";
    }

}
