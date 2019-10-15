package com.edudigital.demo.service.impl;

import com.edudigital.demo.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author liuwei
 * @date 2019/10/15
 */
@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public <T> T exchange(String url, HttpMethod httpMethod, Object param, Class<T> responseClass){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> entity = new HttpEntity<>(param, headers);
        ResponseEntity<T> responseEntity = this.restTemplate.exchange(url, httpMethod, entity, responseClass);
        return responseEntity.getBody();
    }


}
