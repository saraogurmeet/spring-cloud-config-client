package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCloudClientApplication {

	@Autowired
	TechPojo pojo;

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudClientApplication.class, args);
	}

	@RequestMapping(value = "/whoami/{username}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String whoami(@PathVariable("username") String username) {

		return String.format("Hello! You're %s from %s and you'll become a(n) %s... %s \n", username, pojo.getCity(),
				pojo.getTechnology(), pojo.getPassword());

	}

}
