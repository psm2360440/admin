package com.kbstar.controller;

import com.kbstar.dto.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @RequestMapping("/")
    public String main(){
        return "index";
    }

    @RequestMapping("/charts")
    public String charts(Model model){
        model.addAttribute("contents", "charts");
        return "index";
    }

    @RequestMapping("/livechart")
    public String livechart(Model model){
        model.addAttribute("contents", "livechart");
        return "index";
    }

    @RequestMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("contents", "contents");
        return "index";
    }

    @RequestMapping("/tables")
    public String tables(Model model){
        List<Item> list = new ArrayList<>();

        list.add(new Item("Tiger Nixon", "System Architect", "Edinburgh", 61, new Date(111,4,25), 320800 ));
        list.add(new Item("Garrett Winters", "Accountant", "Tokyo", 63, new Date(111,7,25), 170750 ));
        list.add(new Item("Ashton Cox", "Junior Technical Author", "San Francisco", 66, new Date(109,1,12), 86000 ));
        list.add(new Item("Cedric Kelly", "Senior Javascript Developer", "Edinburgh", 22, new Date(112,3,29), 433060 ));
        list.add(new Item("Airi Satou", "Accountant", "Tokyo", 33, new Date(108,11,28), 162700 ));
        list.add(new Item("Brielle Williamson", "Integration Specialist", "New York", 61, new Date(112,11,02), 372000 ));
        list.add(new Item("Herrod Chandler", "Sales Assistant", "San Francisco", 59, new Date(112,7,06), 137500 ));
        list.add(new Item("Rhona Davidson", "Integration Specialist", "Tokyo", 55, new Date(110,10,14), 327900 ));
        list.add(new Item("Colleen Hurst", "Javascript Developer", "San Francisco", 39, new Date(109,9,15), 205500 ));
        list.add(new Item("Sonya Frost", "JSoftware Engineer", "Edinburgh", 23, new Date(108,10,13), 103600 ));
        list.add(new Item("Jena Gaines", "Office Manager", "London", 30, new Date(108,10,19), 90560 ));
        list.add(new Item("Quinn Flynn", "Support Lead", "Edinburgh", 22, new Date(113,3,03), 342000 ));
        list.add(new Item("Charde Marshall", "Regional Director", "San Francisco", 36, new Date(108,10,16), 470600 ));
        list.add(new Item("Haley Kennedy", "Senior Marketing Designer", "London", 43, new Date(112,11,18), 313500 ));
        list.add(new Item("Tatyana Fitzpatrick", "Regional Director", "London", 19, new Date(110,3,17), 385750 ));
        list.add(new Item("Michael Silva", "Marketing Designer", "London", 22, new Date(112,11,27), 198500 ));
        list.add(new Item("Paul Byrd", "Chief Financial Officer (CFO)", "New York", 64, new Date(110,6,01), 725000 ));
        list.add(new Item("Gloria Little", "Systems Administrator", "New York", 59, new Date(109,4,10), 237500));
        list.add(new Item("Bradley Greer", "Software Engineer", "London", 41, new Date(112,10,13), 132000 ));
        list.add(new Item("Dai Rios", "Personnel Lead", "Edinburgh", 35, new Date(112,2,26), 217500 ));

        model.addAttribute("allitem", list);

        model.addAttribute("contents", "tables");
        return "index";
    }

}
