package com.elar.elarbase.repos;

import com.elar.elarbase.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

//    User findByLogin (String username);
    User findByUsername(String username);
}
