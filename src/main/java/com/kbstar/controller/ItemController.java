package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.dto.Item;
import com.kbstar.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {

    String dir = "item/";

    @Autowired
    ItemService itemService;

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("contents", dir+"add");
        return "index";
    }

    @RequestMapping("/all")
    public String all(Model model) throws Exception{
        List<Item> list = null;
        list = itemService.get();
        model.addAttribute("ilist", list);
        model.addAttribute("contents", dir+"all");
        return "index";
    }

    @RequestMapping("/detail")
    public String detail(Model model,Integer id) throws Exception {
        Item item = null;
        item = itemService.get(id);

        model.addAttribute("cust", item);
        model.addAttribute("contents", dir+"detail");
        return "index";
    }

}
