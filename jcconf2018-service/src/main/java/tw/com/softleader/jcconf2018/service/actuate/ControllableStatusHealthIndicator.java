package tw.com.softleader.jcconf2018.service.actuate;

import java.net.InetAddress;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import tw.com.softleader.jcconf2018.service.common.EnvVeriable;

/**
 * server 狀態可以透過外部操作的 HealthIndicator
 */
@Component
public class ControllableStatusHealthIndicator extends AbstractHealthIndicator {

	@Override
	protected void doHealthCheck(Health.Builder builder) throws Exception {
		final InetAddress localHost = InetAddress.getLocalHost();

		builder.status(EnvVeriable.INSTANT.getStatus());
		builder.withDetail("host", localHost.toString());
	}
}
