package lv.elearning.elearningProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ElearningProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElearningProjectApplication.class, args);
	}

}
