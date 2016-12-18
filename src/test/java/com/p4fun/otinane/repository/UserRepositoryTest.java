package com.p4fun.otinane.repository;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */

import com.p4fun.otinane.OtinaneApplication;
import com.p4fun.otinane.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OtinaneApplication.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;



    @Test
    @Transactional
    public void testInsertUserSuccess() throws Exception{
        String username="test";
        String password="12345";

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPasswordConfirm(password);
        userRepository.saveAndFlush(user);

        User dbUser=userRepository.findByUsername(username);

        Assert.assertNotNull(dbUser);
        Assert.assertEquals(username, dbUser.getUsername());
        Assert.assertEquals(password, dbUser.getPassword());

        //Δημιουργεία συναρτησης για διαγραφή χρήστη
        //userRepository.delete(username);
    }

    @Test
    public void testFindOneFailNoSuchUser() throws Exception{
        String username="test";

        User dbUser=userRepository.findByUsername(username);
        Assert.assertNull(dbUser);

    }

   


}