package com.compulsory;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Gigi");
        Player player2 = new Player("Costi");
        Board board = new Board(100);
        Game game = new Game(board);
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.play();
    }
}
