package tw.com.softleader.jcconf2018.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Jcconf2018ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jcconf2018ServiceApplication.class, args);
	}
}
