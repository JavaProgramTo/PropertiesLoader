package com.javaprogramto.properties.PropertiesLoaderdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;

@PropertySource("classpath:success-codes.properties")
@SpringBootApplication
public class PropertiesLoaderDemoApplication {

	private static Logger logger = LoggerFactory.getLogger(PropertiesLoaderDemoApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(PropertiesLoaderDemoApplication.class,
				args);
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		logger.info("loaded locations : "+environment.getPropertySources());
		String welcomeNote = environment.getProperty("welcome.text");
		logger.info("welcome.text value : " + welcomeNote);
		
		// loading from profile
		
		String errorCode400 = environment.getProperty("error.400");
		logger.info("errorCode400 : "+errorCode400);
		
		String successCode200 = environment.getProperty("success.200");
		logger.info("successCode200 : "+successCode200);
	}

}
