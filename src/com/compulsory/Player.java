package com.compulsory;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {
    private String name;
    private Board board;
    private int myTurn;
    private List<Token> myTokens;

    @Override
    public void run() {
        do {
            myTokens.add(board.extractToken(this));
        } while (myTokens.get(myTokens.size() - 1) != null);
        myTokens.remove(null);
        endMsg();
    }

    public synchronized void endMsg(){
        System.out.println("Player: " + name + " has: " + myTokens.toString());
    }

    public Player(String name) {
        this.name = name;
        this.myTokens = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getMyTurn() {
        return myTurn;
    }

    public void setMyTurn(int myTurn) {
        this.myTurn = myTurn;
    }
}
