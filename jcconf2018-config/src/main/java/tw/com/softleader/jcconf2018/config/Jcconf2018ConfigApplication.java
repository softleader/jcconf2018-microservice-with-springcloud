package tw.com.softleader.jcconf2018.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@SpringBootApplication
public class Jcconf2018ConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jcconf2018ConfigApplication.class, args);
	}
}
