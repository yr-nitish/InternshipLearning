package com.ateffigo.learn_spring_framework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
class MyBusinessClass{

//	Usinng field injection
//	@Autowired
//	Dependency1 dependency1;
//
//	@Autowired
//	Dependency2 dependency2;


//	Using setters injection
//	Dependency1 dependency1;
//
//	Dependency2 dependency2;
//	@Autowired
//	public void setDependency1 (Dependency1 dependency1) {
//		this.dependency1=dependency1;
//	}
//
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		this.dependency2 = dependency2;
//	}

	Dependency1 dependency1;

	Dependency2 dependency2;

//	@Autowired
//	In constructor injection, autowiring is not necessary
	public MyBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		System.out.println("Constructor Injection - MyBusinessClass ");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

	public  String toString()
	{
		return  "Using " + dependency1 + " and " + dependency2;
	}
}
@Component
class Dependency1{

}
@Component
class Dependency2{

}
@Configuration
@ComponentScan // if w don't specify the package name, it will automatically perform the scan on current package
@SpringBootApplication
public class DependencyInjectionLauncherApplication {

	public static void main(String[] args) {

		try(var context = new AnnotationConfigApplicationContext
				(DependencyInjectionLauncherApplication.class)) {

			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

			System.out.println(context.getBean(MyBusinessClass.class));
		}
	}
}
