package tw.com.softleader.jcconf2018.feign.stub;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("service")
public interface SampleStub {

	@RequestMapping(value = "/sample/echoip", method = RequestMethod.GET)
	ResponseEntity<String> echoip();

}
