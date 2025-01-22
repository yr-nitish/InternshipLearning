package com.ateffigo.learn_spring_framework.examples.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class NormalClass{


}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass{


}

@Configuration
@ComponentScan // if w don't specify the package name, it will automatically perform the scan on current package
@SpringBootApplication
public class BeanScopesLauncherApplication {

	public static void main(String[] args) {

		try(var context = new AnnotationConfigApplicationContext
				(BeanScopesLauncherApplication.class)) {

//			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));


			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));

		}
	}
}
