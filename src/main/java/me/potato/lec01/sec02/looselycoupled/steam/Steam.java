package me.potato.lec01.sec02.looselycoupled.steam;

import me.potato.lec01.sec02.looselycoupled.games.Game;

public class Steam {
    public void launchGame(Game game) {
        game.launch();
    }
}