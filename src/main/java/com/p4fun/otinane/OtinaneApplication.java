package com.p4fun.otinane;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class OtinaneApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OtinaneApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(OtinaneApplication.class, args);
	}
}
