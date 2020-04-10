package com.compulsory;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private int turn;
    private static Boolean stop;
    private int playersNumber;

    public Game(Board board) {
        this.board = board;
        stop = false;
        players = new ArrayList<>();
        turn = 0;
    }

    public void play(){
        for (int i = 0; i < playersNumber; i++) {
            new Thread(players.get(i)).start();
        }
    }

    public void addPlayer(Player player){
        players.add(player);
        player.setMyTurn(playersNumber++);
        player.setBoard(board);
    }

    public int getTurn() {
        return turn;
    }

    public synchronized void setTurn() {
        this.turn = (turn + 1) % playersNumber;
    }

    public Boolean getStop() {
        return stop;
    }

    public Boolean setStop(Boolean stop) {
        return this.stop = stop;
    }
}
