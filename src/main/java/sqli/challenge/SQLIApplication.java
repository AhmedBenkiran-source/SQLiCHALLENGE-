package sqli.challenge;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class SQLIApplication  implements CommandLineRunner {
	
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(SQLIApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

	}
}
