package me.potato.lec02.sec01.spring.steam;

import me.potato.lec02.sec01.spring.games.Game;
import org.springframework.stereotype.Service;

@Service
public class Steam {
    public void launchGame(Game game) {
        game.launch();
    }
}