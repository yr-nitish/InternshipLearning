package com.ateffigo.learn_spring_framework.examples.f1;

import ch.qos.logback.core.joran.spi.ConsoleTarget;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass{
	private SomeDependency someDependency;

	public SomeClass(SomeDependency someDependency)
	{
		this.someDependency=someDependency;
		System.out.println("All dependencies are ready!");
	}

	@PostConstruct
	public  void initialize(){
		someDependency.getReady();
	}

	@PreDestroy
    public void cleanup(){
		System.out.println("Cleanup");
	}

}

@Component
class SomeDependency{
	public void getReady()
	{
		System.out.println("Some logic using SomeDependency");
	}

}

@Configuration
@ComponentScan // if w don't specify the package name, it will automatically perform the scan on current package
@SpringBootApplication
public class PrePostAnnotationsContextLauncherApplication {

	public static void main(String[] args) {

		try(var context = new AnnotationConfigApplicationContext
				(PrePostAnnotationsContextLauncherApplication.class)) {

			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

		}
	}
}
