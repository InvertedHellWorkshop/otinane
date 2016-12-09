package com.p4fun.otinane.service;

import com.p4fun.otinane.model.Inventory;
import com.p4fun.otinane.model.Item;
import com.p4fun.otinane.model.User;
import com.p4fun.otinane.repository.InventoryRepository;
import com.p4fun.otinane.repository.ItemRepository;
import com.p4fun.otinane.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hrystos on 8/12/2016.
 */

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> getUserItems(String username){
        User user = userRepository.findByUsername(username);
        System.out.println("id: " + user.getId() + ", Username: " + user.getUsername());
        return itemRepository.GetInventoryByUserId(user.getId());

    }

    @Override
    public void addItemToInventory(String username, String itemName){
        User user = userRepository.findByUsername(username);
        Item item = itemRepository.findByName(itemName);
        Inventory i = new Inventory();
        i.setUserId(user.getId());
        i.setItemId(item.getId());
        inventoryRepository.save(i);
    }

}
