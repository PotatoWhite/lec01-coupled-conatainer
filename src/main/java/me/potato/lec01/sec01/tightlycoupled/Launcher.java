package me.potato.lec01.sec01.tightlycoupled;

import me.potato.lec01.sec01.tightlycoupled.games.AssassinsCreed;
import me.potato.lec01.sec01.tightlycoupled.games.CounterStrike;
import me.potato.lec01.sec01.tightlycoupled.steam.Steam;

public class Launcher {
    public static void main(String[] args) {

        // create steam
        var steam = new Steam();

        System.out.println("Launching Steam...");

        // create assassin's creed
        var assassinsCreed = new AssassinsCreed();

        // launch assassin's creed
        steam.launchGame(assassinsCreed);

        // create counter strike
        var counterStrike = new CounterStrike();

        // launch counter strike
        steam.launchGame(counterStrike);

        System.out.println("Closing Steam...");
    }
}
