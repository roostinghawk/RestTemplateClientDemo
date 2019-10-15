package com.edudigital.demo.controller;

import com.edudigital.demo.service.RestTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * RestTemplate测试用Server端接口
 * @author liuwei
 * @date 2019/10/15
 */
@Slf4j
@RequestMapping("/test")
@RestController
public class ClientController {

    private static String url = "http://127.0.0.1:9001/transactions";

    @Autowired
    private RestTemplateService restTemplateService;

    @RequestMapping(method = RequestMethod.GET)
    public Object getAll(){
        Object object = restTemplateService.exchange(url, HttpMethod.GET, new Object(), Object.class);


        return object;
    }
}
