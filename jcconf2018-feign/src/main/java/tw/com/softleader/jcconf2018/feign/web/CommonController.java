package tw.com.softleader.jcconf2018.feign.web;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.softleader.jcconf2018.feign.stub.SampleStub;

@RestController
@RequestMapping(value = "/common", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CommonController {

	public static final String SERVICE_NAME = "service";
	@Autowired
	private SampleStub sampleStub;

	@GetMapping("/echoip/{serviceName}")
	public ResponseEntity<Map<String, String>> echoip(@PathVariable String serviceName) throws UnknownHostException {
		final Map<String, String> ips = new HashMap<>();

		final InetAddress localHost = InetAddress.getLocalHost();
		ips.put("current", localHost.toString());

		if (SERVICE_NAME.equals(serviceName)) {
			final ResponseEntity<String> serviceIp = sampleStub.echoip();
			ips.put(SERVICE_NAME, serviceIp.getBody());
		} else {
			throw new IllegalArgumentException("serviceName not defined");
		}

		return ResponseEntity.ok(ips);
	}

}
