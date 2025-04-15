package com.learn.spring.boot.introduction_spring_boot;

import com.learn.spring.boot.introduction_spring_boot.bakery.CakeBakerService;
import com.learn.spring.boot.introduction_spring_boot.bakery.CakeBakerServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntroductionSpringBootApplication implements CommandLineRunner {

	/*@Autowired
	Apple apple1;

	@Autowired
	Apple apple2;*/

	@Autowired
	DBService dbService;

	/*@Autowired
	CakeBakerService cakeBakerService;*/

	@Autowired
	CakeBakerServiceV2 cakeBakerServiceV2;

	public static void main(String[] args) {
		SpringApplication.run(IntroductionSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(dbService.getData());

		System.out.println("\n-----------------------------------------------------------------------");
		cakeBakerServiceV2.makeCake("chocolate");
		System.out.println("\n-----------------------------------------------------------------------");
		cakeBakerServiceV2.makeCake("Strawberry");

		/*System.out.println("\n-----------------------------------------------------------------------");
		cakeBakerService.makeCake("chocolate");
		System.out.println("\n-----------------------------------------------------------------------");
		cakeBakerService.makeCake("chocolate");*/
		/*apple1.eatApple();
		apple2.eatApple();
		System.out.println(apple1.equals(apple2));
		System.out.println(apple1);
		System.out.println(apple2);*/
	}
}
