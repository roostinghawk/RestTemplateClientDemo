package com.edudigital.demo.service;

import org.springframework.http.HttpMethod;

/**
 * @author liuwei
 * @date 2019/10/15
 */
public interface RestTemplateService {

    <T> T exchange(String url, HttpMethod httpMethod, Object param, Class<T> responseClass);
}
