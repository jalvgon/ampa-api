package com.ampa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;



@SpringBootApplication
@EnableEncryptableProperties
public class AmpaApiApplication {
	
	//private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(AmpaApiApplication.class, args);
	}

	/*@Bean
	CommandLineRunner createPasswordCommand() {
		return args -> {
			 System.out.println(passwordEncoder.encode("Chanquete23"));
		};
	}*/
}
