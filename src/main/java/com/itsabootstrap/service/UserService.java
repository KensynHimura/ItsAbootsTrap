package com.itsabootstrap.service;

import com.itsabootstrap.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User getUserByName(String name);

    List<User> listUsers();

    void saveOrUpdateUser(User user);

    void deleteUser(Long id);

    User getUserByID(Long id);

    User loadUserByUsername(String username);
}
