package me.potato.lec02.sec02.springweb.controller;

import me.potato.lec02.sec02.springweb.controller.dto.GameRequest;
import me.potato.lec02.sec02.springweb.games.AssassinsCreed;
import me.potato.lec02.sec02.springweb.games.CounterStrike;
import me.potato.lec02.sec02.springweb.steam.Steam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("steam")
public class SteamController {
    @Autowired
    private Steam steam;

    @PostMapping("launch")
    public void launch(@RequestBody GameRequest game) {
        switch (game.getName()) {
            case "Assassin's Creed":
                steam.launchGame(new AssassinsCreed());
                break;
            case "Counter-Strike":
                steam.launchGame(new CounterStrike());
                break;
            default:
                throw new IllegalArgumentException("Game not found");
        }
    }
}
