package com.ateffigo.learn_spring_framework;

import com.ateffigo.learn_spring_framework.game.GameRunner;
import com.ateffigo.learn_spring_framework.game.PacManGame;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App01GamingBasicJava {

	public static void main(String[] args) {
//		var game = new MarioGame();

//		var game = new SuperContraGame();
		var game = new PacManGame();
		var gameRunner = new GameRunner(game);

//		SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		gameRunner.run();
	}

}
