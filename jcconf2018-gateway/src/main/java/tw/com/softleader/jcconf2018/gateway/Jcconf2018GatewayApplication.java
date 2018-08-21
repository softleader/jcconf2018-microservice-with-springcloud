package tw.com.softleader.jcconf2018.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Jcconf2018GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jcconf2018GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		// TODO 這邊的寫法沒辦法和 https://www.youtube.com/watch?v=TwVtlNX-2Hs 一樣
		return builder.routes()
				.route(r -> r
						.path("/**") // FIXME
						.uri("lb://service") // FIXME
				)
				.build();
	}

}
