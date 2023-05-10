package com.kbstar.controller;

import com.kbstar.dto.Adm;
import com.kbstar.dto.Chart;
import com.kbstar.service.AdmService;
import com.kbstar.service.ChartService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
public class AjaxImplController {

    @Autowired
    AdmService admService;
    @RequestMapping("/checkid")
    public Object checkid(String id) throws Exception {

        int result = 0;
        Adm adm = null;
        try {
            adm = admService.get(id);
        } catch (Exception e) {
            throw new Exception("시스템 장애: ER0005");
        }
        if(adm!=null){
            result = 1;
        }
        return result;
    }

    @Autowired
    ChartService chartService;

    @RequestMapping("/chart1")
    public Object chart1(String id) throws Exception {

        List<Chart> chart = null;
        chart = chartService.getMonthlyTotal();
        JSONArray fma = new JSONArray();
        JSONArray ma = new JSONArray();

        for(Chart c:chart){
            if(c.getGender().toUpperCase().equals("F")){
                fma.add(c.getTotal());
            } else {
                ma.add(c.getTotal());
            }
        }
        JSONObject jo = new JSONObject();
        JSONObject jo2 = new JSONObject();
        jo.put("name","Female");
        jo.put("data", fma);
        jo2.put("name", "Male");
        jo2.put("data", ma);
        JSONArray data = new JSONArray();

        data.add(jo);
        data.add(jo2);

        return data;
    }
}
