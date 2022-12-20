package com.example.camunda.firstcamunda;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.Topology;
import io.camunda.zeebe.spring.client.EnableZeebeClient;
import io.camunda.zeebe.spring.client.lifecycle.ZeebeClientLifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableZeebeClient
@RestController
public class FirstcamundaApplication {

	@Autowired
	private ZeebeClientLifecycle client;

	public static void main(String[] args) {
		SpringApplication.run(FirstcamundaApplication.class, args);
	}

	@GetMapping("/status")
	public String topology()
	{
		Topology tp = client.newTopologyRequest().send().join();
		return tp.toString();
	}

}
