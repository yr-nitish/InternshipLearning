package com.ateffigo.learn_spring_framework;

import com.ateffigo.learn_spring_framework.game.GameRunner;
import com.ateffigo.learn_spring_framework.game.GamingConsole;
import com.ateffigo.learn_spring_framework.game.PacManGame;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class App03GamingSpringBeansJava {

	public static void main(String[] args) {

		try(var context = new AnnotationConfigApplicationContext
				(GamingConfiguration.class)) {
			context.getBean(GamingConsole.class).up();

			context.getBean(GameRunner.class).run();
		}
	}
}
