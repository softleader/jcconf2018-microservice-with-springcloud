package tw.com.softleader.jcconf2018.service.web;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sample", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SampleController {

	@GetMapping("/echoip")
	public ResponseEntity<String> echoip() throws UnknownHostException {
		final InetAddress localHost = InetAddress.getLocalHost();
		return ResponseEntity.ok(localHost.toString());
	}

}
