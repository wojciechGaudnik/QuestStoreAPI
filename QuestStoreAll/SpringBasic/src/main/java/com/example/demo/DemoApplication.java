package com.example.demo;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.text.View;
import javax.swing.text.ViewFactory;

public class DemoApplication {

	public static final String version = "";

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
		String testString = "aaaaaaa";

//		PalindromeService ps = new PalindromeServiceImpl();
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"META_INF/beans.xml");
		BeanFactory factory = context;

		PalindromeService palindromeService = (PalindromeService) factory.getBean("palindromeServiceImpl");
		String result = palindromeService.getResult(testString);
		System.out.println(result);
		//		View view = new ViewFactory()

//		System.out.println(ps.getResult(testString));

	}

}
