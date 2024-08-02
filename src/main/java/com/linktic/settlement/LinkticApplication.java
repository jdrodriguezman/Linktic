package com.linktic.settlement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(value = "com.linktic.settlement.entity")
@SpringBootApplication
public class LinkticApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkticApplication.class, args);
	}

}
