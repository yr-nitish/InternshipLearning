package com.ateffigo.learn_spring_framework.game;

import ch.qos.logback.core.net.SyslogOutputStream;

public class MarioGame implements GamingConsole{
    public void up()
    {
        System.out.println("Jump");
    }

    public void down()
    {
        System.out.println("Go into a hole");
    }
    public void left()
    {
        System.out.println("Go back");
    }
    public void right()
    {
        System.out.println("Accelerate");
    }
}
