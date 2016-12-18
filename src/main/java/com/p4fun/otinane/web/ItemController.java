package com.p4fun.otinane.web;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */

import com.p4fun.otinane.model.Item;
import com.p4fun.otinane.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
    @RequestMapping(value = "/answerform")
    public String answerform(@RequestParam String fname0, Model model) {

        boolean flag = false;
        List<Item> listItem = itemService.getAllItems();
        for(int i = 0;i<1;i++) {
            if (fname0.equals(listItem.get(0).getSapantisi())) {

                flag = true;
            }

            if (flag) {
                model.addAttribute("message", "Success. Your answer for the riddle about books is Correct");
                model.addAttribute("flag1", "ok");
            } else {
                model.addAttribute("message]", "Wrong Answer, Please try again");
                model.addAttribute("flag1", "no");
            }
            model.addAttribute("apantisi", fname0);
        }
        return "map";
    }

    @RequestMapping(value = "/answerform1")
    public String answerform1(@RequestParam String fname1, Model model) {

        boolean flag = false;
        List<Item> listItem = itemService.getAllItems();
        for(int i = 1; i <2;i++) {
            if (fname1.equals(listItem.get(1).getSapantisi())) {

                flag = true;
            }

            if (flag) {
                model.addAttribute("message", "Successsd . Your answer for the riddle about food is Correct");
                model.addAttribute("flag2", "ok");
            } else {
                model.addAttribute("message", "Wrong Answer, Please try again");
                model.addAttribute("flag2", "no");
            }
            model.addAttribute("apantisi", fname1);
        }
        return "map";
    }
}
