package com.p4fun.otinane.service;

import com.p4fun.otinane.OtinaneApplication;
import com.p4fun.otinane.model.User;
import com.p4fun.otinane.repository.RoleRepository;
import com.p4fun.otinane.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by Hrystos on 20/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OtinaneApplication.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;


    @Test
    public void testAddUserSuccess() throws Exception{
        String username="qwerty";
        String password="12345678";

        User user = new User();
        user.setUsername(username);
        user.setPasswordConfirm(password);
        user.setPassword(password);

        userService.save(user);

        Mockito.verify(userRepository, VerificationModeFactory.times(1)).save(Mockito.any(User.class));
        Mockito.reset(userRepository);
    }

}