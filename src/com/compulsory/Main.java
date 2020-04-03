package com.compulsory;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(100);
        Player player = new Player();
        player.setBoard(board);
        player.setName("Costel");
        new Thread(player);
    }
}
