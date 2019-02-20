package com.example.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.Greeting;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
public class DemoApplication {

	private static final String template = "Hello, %s";
	private final AtomicLong count = new AtomicLong();


	@GetMapping(value="/greeting")
    public Greeting greetings(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(count.incrementAndGet(), String.format(template, name));
    }	

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
