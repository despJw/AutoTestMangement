package com.crc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import com.crc.config.CorSFilter_bak;

@SpringBootApplication
public class AutoTestMangementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoTestMangementSystemApplication.class, args);
	}
}
