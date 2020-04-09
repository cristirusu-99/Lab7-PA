package com.compulsory;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private List<Thread> playerThreads;
    private Board board;
    private int turn;

    public Game(){
        this.players = new ArrayList<>();
        this.playerThreads = new ArrayList<>();
    }

    public  Game(Board board){
        this.players = new ArrayList<>();
        this.playerThreads = new ArrayList<>();
        this.board = board;
    }

    public void play(){
        for (Player player : players) {
            playerThreads.add(new Thread(player));
        }
        for (Thread thread : playerThreads){
            thread.start();
        }
        this.turn = 0;
        while (!board.isEmpty()){
            players.get(turn).notify();
        }
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public synchronized void setTurn() {
        this.turn = (this.turn + 1) % players.size();
    }

    public int getTurn(){
        return this.turn;
    }
}
