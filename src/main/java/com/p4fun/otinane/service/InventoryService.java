package com.p4fun.otinane.service;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */

import com.p4fun.otinane.model.Item;

import java.util.List;

public interface InventoryService {
    List<Item> getUserItems (String username);
    void addItemToInventory(String username, String itemName);
}
