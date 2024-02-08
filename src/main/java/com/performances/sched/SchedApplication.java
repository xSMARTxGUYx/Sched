package com.performances.sched;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.performances.sched")
public class SchedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedApplication.class, args);
	}

}
