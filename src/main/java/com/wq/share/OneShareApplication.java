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
			log.info("=== share-api begin to start====");
			SpringApplication.run(OneShareApplication.class, args);
			log.info("=== share-api start successfully====");
		} catch (Exception e) {
			log.error("==== share-api start with exception====", e);
		}
	}
}
