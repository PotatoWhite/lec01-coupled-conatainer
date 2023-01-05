package me.potato.lec02.sec02.springweb.controller.dto;

public class GameRequest {
    private String name;

    public GameRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GameRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}