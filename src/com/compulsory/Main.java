package com.compulsory;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(100);
        Player player1 = new Player();
        player1.setBoard(board);
        player1.setName("Costel");
        Player player2 = new Player();
        player2.setBoard(board);
        player2.setName("Gigi");
        Game game = new Game(board);
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.play();
    }
}
