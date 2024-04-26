package com.ashishnitw.springbootservicetemplate.service;

import com.ashishnitw.springbootservicetemplate.config.downstream.WebhookServiceConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class WebhookService {

    private final RestTemplate restTemplate;
    private final WebhookServiceConfig webhookServiceConfig;

    public void webhook(Object request) {
        log.info("sending request #" + Thread.currentThread().getName());
        webhookPost(request);
        log.info("request sent #" + Thread.currentThread().getName());
    }

    public void webhookBulk(Object request) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    webhookPost(request);
                    log.info("request sent #" + Thread.currentThread().getName());
                } catch (Exception e) {
                    log.error("Error in webhookPost: {}", e.getMessage());
                }
            }).start();
        }
    }

    public void webhookPost(Object request) {
        long start = System.currentTimeMillis();
        restTemplate.postForEntity(webhookServiceConfig.getUrl(), request, Object.class);
        long end = System.currentTimeMillis();
        log.info("time taken = " + (end - start) + " ms");
    }
}
