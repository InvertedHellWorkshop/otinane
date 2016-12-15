package com.p4fun.otinane.service;

import com.p4fun.otinane.model.Item;

import java.util.List;

/**
 * Created by Hrystos on 8/12/2016.
 */
public interface InventoryService {
    List<Item> getUserItems (String username);
    void addItemToInventory(String username, String itemName);
}
