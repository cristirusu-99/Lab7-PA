package com.compulsory;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Board {
    private int tokenNumber;
    private List<Token> tokens;
    private Game game;


    Board(int tokenNumber) {
        this.tokens = new ArrayList<>();
        this.tokenNumber = tokenNumber;
        Token newToken;
        for(int i = 1; i<=tokenNumber; ++i) {
            newToken = new Token(i);
            tokens.add(newToken);
        }
    }

    public synchronized Token extract(@NotNull Player player) {
        Token pickedToken = null;
        try {
            this.notify();
            while (player.getMyTurn() != game.getTurn()) {
                this.wait(10);
            }
            if (this.isEmpty()) {
                this.notifyAll();
                game.setTurn();
                return null;
            }
            System.out.println("Board: Tura jucatorului " + player.getName());
            //printTokens();
            pickedToken = player.pickToken(this);
            System.out.println("Tura jucatorului " + player.getName() + " s-a sfarsit\n");
            game.setTurn();
        } catch (Exception ignored) {
            System.out.println("Crapa ?");
        }
        return pickedToken;
    }

    public boolean isEmpty(){
        return this.tokenNumber==0;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
