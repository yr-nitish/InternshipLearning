package com.ateffigo.learn_spring_framework.game;

public class PacManGame implements GamingConsole {
    public void up()
    {
        System.out.println("Swim");
    }
    public void down()
    {
        System.out.println("Relax");
    }
    public void left()
    {
        System.out.println("Turn left");
    }
    public void right()
    {
        System.out.println("Turn Right");
    }
}
