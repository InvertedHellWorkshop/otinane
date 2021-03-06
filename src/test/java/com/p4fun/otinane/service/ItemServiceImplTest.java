package com.p4fun.otinane.service;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */

import com.p4fun.otinane.OtinaneApplication;
import com.p4fun.otinane.model.Item;
import com.p4fun.otinane.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OtinaneApplication.class)
public class ItemServiceImplTest {

    @InjectMocks
    private ItemServiceImpl itemService;

    @Mock
    private ItemRepository itemRepository;



    @Test
    public void testAddItemSuccess() throws Exception{
        List<Item> items = new ArrayList<>();

        items.addAll(itemService.getAllItems());

        Mockito.verify(itemRepository, VerificationModeFactory.times(1)).GetAll();
        Mockito.reset(itemRepository);
    }

}