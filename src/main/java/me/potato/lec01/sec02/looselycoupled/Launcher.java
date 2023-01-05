package me.potato.lec01.sec02.looselycoupled;

import me.potato.lec01.sec01.tightlycoupled.games.AssassinsCreed;
import me.potato.lec01.sec01.tightlycoupled.games.CounterStrike;
import me.potato.lec01.sec01.tightlycoupled.steam.Steam;

public class Launcher {
    public static void main(String[] args) {

        // create steam
        var steam = new Steam();

        System.out.println("Launching Steam...");

        var assassinsCreed = new AssassinsCreed();
        steam.launchGame(assassinsCreed);

        var counterStrike = new CounterStrike();
        steam.launchGame(counterStrike);

        System.out.println("Closing Steam...");
    }
}
