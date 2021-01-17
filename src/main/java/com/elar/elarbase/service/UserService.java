package com.elar.elarbase.service;

import com.elar.elarbase.domain.Role;
import com.elar.elarbase.domain.User;
import com.elar.elarbase.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private  UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepo.findByLogin(username);
        return userRepo.findByUsername(username);

    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public void saveUser(User user, String surname, String username, Map<String, String> form) {
        user.setUsername(username);
        user.setSurname(surname);

        Set<Object> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();
        for (String key : form.keySet()) {
            if (roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepo.save(user);
    }


    public void updateProfile(User user, String password, String surname) {
        user.setSurname(surname);
        user.setPassword(password);

        userRepo.save(user);
    }
}
