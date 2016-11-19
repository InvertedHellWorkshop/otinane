package com.p4fun.otinane.model;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */

import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.Field;

public class UserTest {

    @Test
    public void testGetUsername() throws Exception {
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("username");
        field.setAccessible(true);
        field.set(user, "otinane");

        final String result = user.getUsername();

        Assert.assertEquals(result, "otinane");
    }

    @Test
    public void testSetUsername() throws Exception {
        final User user = new User();

        user.setUsername("otinane");

        final Field field = user.getClass().getDeclaredField("username");
        field.setAccessible(true);
        Assert.assertEquals(field.get(user), "otinane");
    }

    @Test
    public void testGetPassword() throws Exception {
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("password");
        field.setAccessible(true);
        field.set(user, "ponos666");

        final String result = user.getPassword();

        Assert.assertEquals(result, "ponos666");
    }

    @Test
    public void testSetPassword() throws Exception {
        final User user = new User();

        user.setPassword("ponos666");

        final Field field = user.getClass().getDeclaredField("password");
        field.setAccessible(true);
        Assert.assertEquals(field.get(user), "ponos666");
    }
}