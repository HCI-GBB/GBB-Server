package site.gbb.gbbserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class GbbserverApplication {
	public static void main(String[] args) {
		SpringApplication.run(GbbserverApplication.class, args);
	}

}
