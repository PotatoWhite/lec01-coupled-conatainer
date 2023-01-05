package me.potato.lec02.sec01.spring;


import me.potato.lec02.sec01.spring.games.AssassinsCreed;
import me.potato.lec02.sec01.spring.games.CounterStrike;
import me.potato.lec02.sec01.spring.steam.Steam;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Steam.class);
        var steam = context.getBean(Steam.class);

        System.out.println("Launching Steam...");

        steam.launchGame(new AssassinsCreed());
        steam.launchGame(new CounterStrike());

        System.out.println("Closing Steam...");
    }
}
