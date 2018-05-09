package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wangbin on 2018/5/9.
 */
@RestController
public class HttpController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/eht")
    public String index(){
        JSONObject aa = this.restTemplate.getForObject("https://api.etherscan.io/api?module=account&action=txlist&address=0x34c5bf6ce9fecbd10bcfafdf60c61ed27533473b&startblock=0&endblock=99999999&sort=asc&apikey=IX3G48RX62MDDSJ1KG7NNSDBTI7A8144HG"
                , JSONObject.class);
        JSONArray.parseArray(aa.getString("result"));
        System.out.println(aa);
        return aa.toJSONString();
    }
}
