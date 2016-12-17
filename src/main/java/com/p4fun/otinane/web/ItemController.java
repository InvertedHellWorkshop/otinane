package com.p4fun.otinane.web;

import com.p4fun.otinane.model.Item;
import com.p4fun.otinane.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Hrystos on 17/12/2016.
 */

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> getAllItems(){
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public  ResponseEntity<Item> getItem(@RequestParam("name")String name){
        return ResponseEntity.ok(itemService.findByName(name));
    }
}
