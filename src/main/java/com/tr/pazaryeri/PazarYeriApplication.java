package com.tr.pazaryeri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.tr.pazaryeri"})
public class PazarYeriApplication {

	public static void main(String[] args) {
		SpringApplication.run(PazarYeriApplication.class, args);
	}

}
