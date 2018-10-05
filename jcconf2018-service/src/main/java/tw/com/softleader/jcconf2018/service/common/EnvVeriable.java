package tw.com.softleader.jcconf2018.service.common;

import org.springframework.boot.actuate.health.Status;

import lombok.Getter;
import lombok.Setter;

/**
 * 系統變數
 */
@Getter
public enum EnvVeriable {

	/**
	 * singleton pattern
	 */
	INSTANT;

	/**
	 * server 狀態
	 */
	@Setter
	private Status status = Status.UP;

}
