package br.com.pteixeira.thoughts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("br.com.pteixeira.thoughts.entity, br.com.pteixeira.thoughts.repository, br.com.pteixeira.thoughts.service, br.com.pteixeira.thoughts.controller, br.com.pteixeira.thoughts.config")
public class ThoughtsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThoughtsApplication.class, args);
	}

}
