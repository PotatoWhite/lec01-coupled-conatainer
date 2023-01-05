package me.potato.lec02.sec02.springweb.games;

public class CounterStrike implements Game {
    public void launch() {
        this.loadGame();
        this.keyUp();
        this.keyDown();
        this.keyLeft();
        this.keyRight();
    }

    private void loadGame() {
        System.out.println("Loading Counter Strike...");
    }

    private void keyUp() {
        System.out.println("Move forward...");
    }

    private void keyDown() {
        System.out.println("Move backward...");
    }

    private void keyLeft() {
        System.out.println("Move left...");
    }

    private void keyRight() {
        System.out.println("Key right...");
    }
}
