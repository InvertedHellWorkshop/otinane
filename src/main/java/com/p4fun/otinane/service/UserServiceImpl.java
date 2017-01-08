package com.p4fun.otinane.service;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */

import com.p4fun.otinane.model.User;
import com.p4fun.otinane.repository.InventoryRepository;
import com.p4fun.otinane.repository.RoleRepository;
import com.p4fun.otinane.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private InventoryRepository inventoryRepository;


    @Override
    public void save(User user) {

        user.setPassword(user.getPassword());
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void resetAccount(String username){
        User user = userRepository.findByUsername(username);
        inventoryRepository.resetAccount(user.getId());
    }
}
