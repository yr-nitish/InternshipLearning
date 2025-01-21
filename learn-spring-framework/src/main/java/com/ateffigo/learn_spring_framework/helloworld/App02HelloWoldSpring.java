package com.ateffigo.learn_spring_framework.helloworld;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class App02HelloWoldSpring {

	public static void main(String[] args) {
		//1: Launch a Spring Context
		try(var context = new AnnotationConfigApplicationContext
				(HelloWorldConfiguration.class)) //try with resources
		{
			//2: Configure the things that we want spring to manage - @Configuration
			//HelloWorldConfiguration - @Configuration
			//name - @Bean

			//3. Retrieving Beans managed vy Spring
			System.out.println(context.getBean("name"));

			System.out.println(context.getBean("age"));

			System.out.println(context.getBean("person"));

			System.out.println(context.getBean("person2MethodCall"));

			System.out.println(context.getBean("person3Parameters"));

			System.out.println(context.getBean("address2"));  // using name of Bean
			System.out.println(context.getBean(Address.class)); //using type of Bean

			System.out.println(context.getBean("person4Qualifier"));
		}

		}

}
