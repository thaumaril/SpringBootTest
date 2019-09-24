package de.rest.begoodtoday;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTests {
	
	@GetMapping(value="/hello")
	public String getMethodName() {
		return "Hello World";
	}


	@Test
	public void contextLoads() {
	}

}
