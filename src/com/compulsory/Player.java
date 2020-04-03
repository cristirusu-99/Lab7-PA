package com.compulsory;

public class Player implements Runnable {
    private String name;
    private Board board;

    @Override
    public void run() {
        Token token = board.extract();
        System.out.println(token.getValue());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
