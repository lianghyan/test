package net.fsd.training.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
@Import({AppConfigTraining.class })
public class FsdApplication {

	@RequestMapping("/")
	String home() {
		return "no application name jsut Hello World!";
	}
	
	@RequestMapping("/fakelogin")
	String login() {
		return "login successfully!";
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();		
		SpringApplication.run(FsdApplication.class, args);
	}
}
