package tw.com.softleader.jcconf2018.eureka.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.registry.InstanceRegistry;

/** @author Matt S.Y Ho */
@RestController
@RequestMapping(value = "/registry", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EurekaRegistryController {

	@Autowired private InstanceRegistry registry;

	@GetMapping(value = "/{appName}")
	public Application getApplication(@PathVariable String appName) {
		return registry.getApplication(appName);
	}

	@GetMapping
	public Applications getApplications() {
		return registry.getApplications();
	}

}
