package com.ashishnitw.springbootservicetemplate.config.downstream;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "webhook")
public class WebhookServiceConfig {
    @Value("${url}")
    private String url;
}
