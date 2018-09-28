package tw.com.softleader.jcconf2018.service.common;

import org.springframework.boot.actuate.health.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum EnvVeriable {

	INSTANT;

	@Setter
	private Status status = Status.UP;

}
