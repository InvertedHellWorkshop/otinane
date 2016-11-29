package com.p4fun.otinane.service;

import com.p4fun.otinane.model.Item;

import java.util.List;

/**
 * Created by Hrystos on 26/11/2016.
 */
public interface ItemService {
    List<Item> getAllItems();
    Item findByName(String name);
}
