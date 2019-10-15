package com.edudigital.demo.controller;

import com.edudigital.demo.dto.TransactionDTO;
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

    private static String url = "http://127.0.0.1:9001/transactions/";

    @Autowired
    private RestTemplateService restTemplateService;

    @RequestMapping(method = RequestMethod.GET)
    public Object getAll(){
        Object object = restTemplateService.exchange(url, HttpMethod.GET, new Object(), Object.class);
        return object;
    }

    @RequestMapping(path = "/{id}",  method = RequestMethod.GET)
    public TransactionDTO get(@PathVariable Long id){
        TransactionDTO object = restTemplateService.exchange(url + id, HttpMethod.GET, new Object(), TransactionDTO.class);
        return object;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object create(){
        TransactionDTO dto = new TransactionDTO();
        dto.setId(9999L);
        dto.setPrice(101.5);
        dto.setName("客户端");
        dto.setUpdateTime(new Date());
        String object = restTemplateService.exchange(url, HttpMethod.POST, dto, String.class);
        return object;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Object update(){
        TransactionDTO dto = new TransactionDTO();
        dto.setId(2019L);
        dto.setPrice(101.5);
        dto.setName("客户端1");
        dto.setUpdateTime(new Date());
        String object = restTemplateService.exchange(url, HttpMethod.PUT, dto, String.class);
        return object;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable Long id){
        String object = restTemplateService.exchange(url + id, HttpMethod.DELETE, new Object(), String.class);
        return object;
    }
}
