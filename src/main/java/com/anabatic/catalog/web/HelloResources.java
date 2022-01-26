package com.anabatic.catalog.web;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anabatic.catalog.dto.HelloMessageResponseDTO;
import com.anabatic.catalog.service.GreetingService;

import ch.qos.logback.classic.Logger;

@RestController
public class HelloResources {
	
	Logger log = (Logger) LoggerFactory.getLogger(HelloResources.class);
	
	private GreetingService greetingService;
	
	

	public HelloResources(GreetingService greetingService) {
		super();
		this.greetingService = greetingService;
	}



	@GetMapping("/hello")
	public ResponseEntity<HelloMessageResponseDTO> helloWorld() {
		log.trace("this is log TRACE");
		log.debug("this is log DEBUG");
		log.info("this is log INFO");
		log.warn("this is log WARN");
		log.error("this is log ERROR");
		HelloMessageResponseDTO dto = new HelloMessageResponseDTO();
		dto.setMessage(greetingService.sayGreeting());
		return ResponseEntity.accepted().body(dto);
	}
	

}
