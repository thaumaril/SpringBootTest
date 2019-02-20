package com.example.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	@GetMapping(value="/hello")
	public String getMethodName() {
		return "Hello World";
	}
	

	@Test
	public void contextLoads() {
	}

}
