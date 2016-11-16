package com.p4fun.otinane.service;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
