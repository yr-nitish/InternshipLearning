package com.ateffigo.learn_spring_framework.game;

public class SuperContraGame implements  GamingConsole{
    public void up()
    {
        System.out.println("Go ahead");
    }
    public void down()
    {
        System.out.println("Sit down");
    }
    public void left()
    {
        System.out.println("Go back");
    }
    public void right()
    {
        System.out.println("Shoot a bullet");
    }
}
