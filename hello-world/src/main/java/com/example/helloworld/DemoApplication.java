package com.example.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@SpringBootApplication
@RestController
public class DemoApplication {

	private static final String template = "Hello";
	private final AtomicLong count = new AtomicLong();


	@GetMapping(value="/greeting")
    public Greeting greetings(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(count.incrementAndGet(), template + " " + name);
	}	
	
	@GetMapping(value="/best")
	public String getMethodName(@RequestParam (value= "name", defaultValue = "Niemand")String name) {
		return name +"  ist der Größte!";
	}
	
	@GetMapping(value="/car")
	public Car getNewCar(@RequestParam (value="brand", defaultValue = "BobyCar")String brand, @RequestParam(value="color", defaultValue = "red")String color, @RequestParam(value="power", defaultValue = "1")int power) {
		return new Car(brand, color, power);
	}
	
	@GetMapping(value="/newmood")
	public Mood getNeMood() {
		return new Mood();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
