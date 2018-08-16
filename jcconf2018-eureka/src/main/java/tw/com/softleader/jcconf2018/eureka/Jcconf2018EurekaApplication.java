package tw.com.softleader.jcconf2018.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Jcconf2018EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jcconf2018EurekaApplication.class, args);
	}
}
