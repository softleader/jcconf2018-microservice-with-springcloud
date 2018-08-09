package tw.com.softleader.jcconfdemo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@SpringBootApplication
public class Jcconf2018DemoConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jcconf2018DemoConfigApplication.class, args);
	}
}
