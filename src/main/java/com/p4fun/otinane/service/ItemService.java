package com.p4fun.otinane.service;

import com.p4fun.otinane.model.Item;

import java.util.List;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */
public interface ItemService {
    List<Item> getAllItems();
    Item findByName(String name);
}
