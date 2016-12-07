package com.p4fun.otinane.repository;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */

import com.p4fun.otinane.OtinaneApplication;
import com.p4fun.otinane.model.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OtinaneApplication.class)
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;



    @Test
    @Transactional
    public void testInsertItemSuccess() throws Exception{
        String name="test";
        double lat= 12345;
        double lon= 67890;
        String desc = "ridle";

        Item item=new Item();
        item.setName(name);
        item.setLatitude(lat);
        item.setLongitude(lon);
        item.setDescription(desc);
        itemRepository.saveAndFlush(item);

        Item dbItem=itemRepository.findByName(name);

        Assert.assertNotNull(dbItem);
        Assert.assertEquals(name, dbItem.getName());
        Assert.assertEquals(lat, dbItem.getLatitude(),0.001);
        Assert.assertEquals(lon, dbItem.getLongitude(),0.001);
        Assert.assertEquals(desc, dbItem.getDescription());

        //Δημιουργία συναρτησης για διαγραφή αντικειμένου
        //itemRepository.delete(name);
    }



}