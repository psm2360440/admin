package com.kbstar.chart;

import com.kbstar.dto.Chart;
import com.kbstar.service.ChartService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class MonthlyTotalTest {
    @Autowired
    ChartService chartService;

    @Test
    void contextLoads() throws Exception {
        try {
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

            log.info("-----------------------------------------------------------------"+data.toJSONString());



        } catch (Exception e) {
            log.info("에러..");
            e.printStackTrace();
        }
    }
}

