package com.compulsory;

public class Player implements Runnable {
    private String name;
    private Board board;
    private int myTurn;

    @Override
    public void run() {
        Token token;
        int i = 0;
        while (true) {
            try {
                System.out.println(name + ": Waiting my turn");
                wait();
            } catch (InterruptedException e) {
                token = board.extract(this);
                System.out.println(name + ": " + token.getValue());
                ++i;
                e.printStackTrace();
            }
        }
    }

    public Token pickToken(Board board){
        return null;
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

    public int getMyTurn() {
        return myTurn;
    }

    public void setMyTurn(int myTurn) {
        this.myTurn = myTurn;
    }
}
