package com.p4fun.otinane.service;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */

import com.p4fun.otinane.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);



    void resetAccount(String username);

}
