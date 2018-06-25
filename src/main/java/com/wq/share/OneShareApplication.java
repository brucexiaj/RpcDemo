package com.wq.share;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:beanRefContext.xml")
@Slf4j
public class OneShareApplication {

	public static void main(String[] args) {

		try {
			log.info("=== oneShare begin to start====");
			SpringApplication.run(OneShareApplication.class, args);
			log.info("=== oneShare start successfully====");
		} catch (Exception e) {
			log.error("==== oneShare start with exception====", e);
		}
	}
}
