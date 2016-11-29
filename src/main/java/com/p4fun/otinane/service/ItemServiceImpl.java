package com.p4fun.otinane.service;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */

import com.p4fun.otinane.model.Item;
import com.p4fun.otinane.model.User;
import com.p4fun.otinane.repository.ItemRepository;
import com.p4fun.otinane.repository.RoleRepository;
import com.p4fun.otinane.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.GetAll();
    }

    @Override
    public Item findByName(String name) {
        return itemRepository.findByName(name);
    }
}
