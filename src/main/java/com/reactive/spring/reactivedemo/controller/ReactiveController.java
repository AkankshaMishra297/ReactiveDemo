package com.reactive.spring.reactivedemo.controller;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.spring.reactivedemo.model.ReactiveModel;

import reactor.core.publisher.Flux;

@RestController
public class ReactiveController {
	
	@GetMapping(path = "/getModel", produces = MediaType.APPLICATION_STREAM_JSON_VALUE )
	public Flux<ReactiveModel> getFluxModel(){
		return Flux.just(new ReactiveModel("1","A","a@gmail.com"),new ReactiveModel("2","B","b@gmail.com"),new ReactiveModel("3","C","c@gmail.com"))
				.delayElements(Duration.ofSeconds(3));
				
		
	}
	
	@GetMapping(path = "/getString", produces = MediaType.APPLICATION_STREAM_JSON_VALUE )
	public Flux<String> getFluxString(){
		return Flux.just("Spring", "SpringBoot", "ReactiveSpring")
		.delayElements(Duration.ofSeconds(3));
	}
	
	
	@GetMapping(path = "/getInt", produces = MediaType.APPLICATION_STREAM_JSON_VALUE )
	public Flux<Integer> getFluxInt(){
		return Flux.range(0, 20)
				.filter(n-> n%2==0)
				.delayElements(Duration.ofSeconds(3));
				
		
	}

}
