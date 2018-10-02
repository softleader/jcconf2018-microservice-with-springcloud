package tw.com.softleader.jcconf2018.service.web;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.stream.Stream;

import javax.validation.ValidationException;

import org.springframework.boot.actuate.health.Status;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.softleader.jcconf2018.service.common.EnvVeriable;

@RestController
@RequestMapping(value = "/sample", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SampleController {

	@GetMapping("/echoip")
	public ResponseEntity<String> echoip() throws UnknownHostException {
		final InetAddress localHost = InetAddress.getLocalHost();
		return ResponseEntity.ok(localHost.toString());
	}

	@GetMapping("/chgsts/{statusTx}")
	public ResponseEntity<String> down(@PathVariable String statusTx) throws UnknownHostException {
		final Status status = Stream.of(Status.UP, Status.DOWN, Status.OUT_OF_SERVICE)
				.filter(s -> s.getCode().equals(statusTx))
				.findFirst()
				.orElseThrow(() -> new ValidationException("Unknow status: [" + statusTx + "]"));

		EnvVeriable.INSTANT.setStatus(status);
		return ResponseEntity.ok("success@" + InetAddress.getLocalHost());
	}

}
