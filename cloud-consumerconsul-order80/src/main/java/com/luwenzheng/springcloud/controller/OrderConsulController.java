package com.luwenzheng.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@Slf4j
public class OrderConsulController {

    @Value("${server.port}")
    private String serverPort;

    private static final String INVOKE_URL="http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/consul")
    public String getConsul(){
        String template = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return template;
    }
}
