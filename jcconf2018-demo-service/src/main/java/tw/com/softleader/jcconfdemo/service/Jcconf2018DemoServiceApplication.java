package tw.com.softleader.jcconfdemo.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Jcconf2018DemoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jcconf2018DemoServiceApplication.class, args);
	}
}
