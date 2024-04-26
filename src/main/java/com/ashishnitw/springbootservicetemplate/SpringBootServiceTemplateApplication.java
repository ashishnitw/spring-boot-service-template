package com.ashishnitw.springbootservicetemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({
		"classpath:application.yml",
		"classpath:common.yml"
})
public class SpringBootServiceTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServiceTemplateApplication.class, args);
	}

}
