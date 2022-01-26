package com.anabatic.catalog.service.impl;

import java.util.TimeZone;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anabatic.catalog.cloud.CloudProperties;
import com.anabatic.catalog.config.ApplicationProperties;
import com.anabatic.catalog.service.GreetingService;
import com.anabatic.catalog.web.HelloResources;

import ch.qos.logback.classic.Logger;


@Service
public class GreetingServiceImpl implements GreetingService{
	
	Logger log = (Logger) LoggerFactory.getLogger(GreetingService.class);
	
	
	private ApplicationProperties appProperties;
	
	private CloudProperties cloudProperties;
	
	@Autowired
	public GreetingServiceImpl(ApplicationProperties appProperties, CloudProperties cloudProperties) {
		super();
		this.appProperties = appProperties;
		this.cloudProperties = cloudProperties;
	}



	@Override
	public String sayGreeting() {
		log.trace("this is log TRACE");
		log.debug("this is log DEBUG");
		log.info("this is log INFO");
		log.warn("this is log WARN");
		log.error("this is log ERROR");
		System.out.println(cloudProperties.getApiKey());
		TimeZone timezone = TimeZone.getTimeZone(appProperties.getTimezone());
;
		
		return appProperties.getWelcomeText()+". our timezone: "+timezone.getDisplayName()+
				". our currency: "+appProperties.getCurrency();
	}

}
