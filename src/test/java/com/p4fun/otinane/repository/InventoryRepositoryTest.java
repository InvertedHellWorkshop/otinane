package com.p4fun.otinane.repository;

import com.p4fun.otinane.OtinaneApplication;
import com.p4fun.otinane.model.Inventory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Hrystos on 11/12/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OtinaneApplication.class)
public class InventoryRepositoryTest {

    @Autowired
    private InventoryRepository inventoryRepository;



    @Test
    @Transactional
    public void testInsertItemInInventory() throws Exception{

        int itemId = 1;
        int userId = 4;

        Inventory i = new Inventory();
        i.setItemId(itemId);
        i.setUserId(userId);
        inventoryRepository.saveAndFlush(i);

        Inventory dbInventoryItem = inventoryRepository.findByUserId(userId);

        Assert.assertNotNull(dbInventoryItem);
        Assert.assertEquals(userId, dbInventoryItem.getUserId());
        Assert.assertEquals(itemId, dbInventoryItem.getItemId());

        //Δημιουργία συναρτησης για διαγραφή αντικειμένου
        //itemRepository.delete(name);
    }

}