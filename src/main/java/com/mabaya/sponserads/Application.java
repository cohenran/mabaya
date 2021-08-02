package com.mabaya.sponserads;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@Slf4j
@EntityScan(basePackageClasses = Application.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void applicationUpAndRunning() throws Exception {
		log.info("Application started!");
	}
}
