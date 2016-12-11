package com.p4fun.otinane.web;

import com.p4fun.otinane.model.Item;

import com.p4fun.otinane.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Hrystos on 7/12/2016.
 */

@Controller
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @RequestMapping(value = "/inventory", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> getUserInventory(@RequestParam("username")String username){
        return ResponseEntity.ok(inventoryService.getUserItems(username));

    }

    @RequestMapping(value = "/inventory", method = RequestMethod.POST)
    public ResponseEntity<?> addItemToInventory(@RequestParam("username")String username,
                                   @RequestParam("item")String item){
        inventoryService.addItemToInventory(username, item);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
