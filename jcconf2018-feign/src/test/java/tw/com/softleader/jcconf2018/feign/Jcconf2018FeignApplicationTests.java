package tw.com.softleader.jcconf2018.feign;

		import org.junit.Test;
		import org.junit.runner.RunWith;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.boot.test.context.SpringBootTest;
		import org.springframework.test.context.junit4.SpringRunner;

		import tw.com.softleader.jcconf2018.feign.stub.SampleStub;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Jcconf2018FeignApplicationTests {

	@Autowired
	private SampleStub sampleStub;

	@Test
	public void contextLoads() {
		System.out.println(sampleStub.echoip());
	}

}
