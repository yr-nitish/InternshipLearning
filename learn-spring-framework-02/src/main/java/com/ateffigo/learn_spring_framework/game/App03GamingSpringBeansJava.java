package com.ateffigo.learn_spring_framework.game;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.ateffigo.learn_spring_framework.game")
@SpringBootApplication
public class App03GamingSpringBeansJava {

//	@Bean
//	public GamingConsole game(){
//		var game=new PacManGame();
//		return game;
//	}
//
//	@Bean
//	public GameRunner gameRunner(GamingConsole game)
//	{
//		var gameRunner = new GameRunner(game);
//		return gameRunner;
//	}

	public static void main(String[] args) {

		try(var context = new AnnotationConfigApplicationContext
				(App03GamingSpringBeansJava.class)) {

			context.getBean(GameRunner.class).run();
		}
	}
}
