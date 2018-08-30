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
		return builder.routes()
				.route(r -> r
						.path("/service/sample/echoip")
						.filters(gatewayFilterSpec -> gatewayFilterSpec.rewritePath("/service/(?<segment>.*)", "/${segment}"))
						.uri("http://service")
				)
				.route(r -> r
						.path("/feign/other/echoip/*")
						.filters(gatewayFilterSpec -> gatewayFilterSpec.rewritePath("/feign/(?<segment>.*)", "/${segment}"))
						.uri("http://feign")
				)
				.build();
	}

}
