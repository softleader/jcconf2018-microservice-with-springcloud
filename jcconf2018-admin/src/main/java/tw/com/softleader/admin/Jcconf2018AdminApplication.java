package tw.com.softleader.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class Jcconf2018AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jcconf2018AdminApplication.class, args);
	}
}
