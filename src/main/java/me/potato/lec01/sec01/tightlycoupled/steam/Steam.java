package me.potato.lec01.sec01.tightlycoupled.steam;

import me.potato.lec01.sec01.tightlycoupled.games.AssassinsCreed;
import me.potato.lec01.sec01.tightlycoupled.games.CounterStrike;

public class Steam {
    public void launchGame(AssassinsCreed assassinsCreed) {
        assassinsCreed.launch();
    }

    public void launchGame(CounterStrike counterStrike) {
        counterStrike.launch();
    }
}