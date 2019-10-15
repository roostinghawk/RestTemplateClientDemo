package com.edudigital.demo;

import com.edudigital.demo.service.RestTemplateService;
import com.edudigital.demo.service.impl.RestTemplateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;

import java.net.InetAddress;
import java.util.HashMap;

/**
 * RestTemplate的Client测试入口
 * @author liuwei
 * @date 2019/10/15
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args){

        final HashMap<String, Object> props = new HashMap<>(16);
        final ConfigurableApplicationContext context = new SpringApplicationBuilder()
                .properties(props)
                .sources(Application.class)
                .run(args);


        RestTemplateService restTemplateService = new RestTemplateServiceImpl();

    }



}
