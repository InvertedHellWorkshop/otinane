package com.p4fun.otinane.web;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */

import com.p4fun.otinane.OtinaneApplication;
import com.p4fun.otinane.model.User;
import com.p4fun.otinane.repository.UserRepository;
import com.p4fun.otinane.service.UserService;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OtinaneApplication.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Mock
    private UserRepository userRepository;


    private MockMvc mockMvc;


    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        User user1 = new User();
        user1.setUsername("TestUser1");
        user1.setPassword("12345678");
        user1.setId(1);
        User user2 = new User();
        user2.setUsername("TestUser2");
        user2.setPassword("12345678");
        user2.setId(2);
        given(this.userRepository.findAll()).willReturn(Lists.newArrayList(user1, user2));
    }

    @Test
    public void testRegistration() throws Exception {

        mockMvc.perform(get("/registration.jsp"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("userForm"))
                .andExpect(view().name("registration"));
    }

    /*@Test
    public void testWelcome() throws Exception {

        mockMvc.perform(get("/","/welcome"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists())
                .andExpect(view().name("welcome"));
    }*/

}