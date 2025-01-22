package com.ateffigo.learn_spring_framework.examples.a0;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
@ComponentScan // if w dont specify the package name, it will automatically perform the scan on current package
@SpringBootApplication
public class SimpleSpringContextLauncherApplication {

	public static void main(String[] args) {

		try(var context = new AnnotationConfigApplicationContext
				(SimpleSpringContextLauncherApplication.class)) {

			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

		}
	}
}
