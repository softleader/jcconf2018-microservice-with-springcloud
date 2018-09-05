package tw.com.softleader.jcconf2018.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Jcconf2018FeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jcconf2018FeignApplication.class, args);
	}

}
