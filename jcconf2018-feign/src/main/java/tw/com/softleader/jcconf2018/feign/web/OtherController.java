package tw.com.softleader.jcconf2018.feign.web;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.softleader.jcconf2018.feign.stub.SampleStub;

@RestController
@RequestMapping(value = "/other", produces = MediaType.APPLICATION_JSON_VALUE)
public class OtherController {

	@Autowired
	private SampleStub sampleStub;

	@GetMapping("/echoip/{serviceName}")
	public ResponseEntity<String> echoip(@PathVariable String serviceName) throws UnknownHostException {
		final String ip;
		if ("service".equals(serviceName)) {
			final ResponseEntity<String> serviceIp = sampleStub.echoip();
			ip = serviceIp.getBody();
		} else {
			throw new IllegalArgumentException("serviceName not defined");
		}

		return ResponseEntity.ok(serviceName + "'s ip = " + ip);
	}

}
