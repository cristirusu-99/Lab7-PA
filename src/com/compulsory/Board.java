package com.compulsory;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Board {
    private int maxTokensNumber;
    private int tokensNumber;
    private List<Token> tokens;
    private Game game;

    public Board(int tokensNumber){
        this.tokensNumber = tokensNumber;
        this.maxTokensNumber = tokensNumber;
        this.tokens = new ArrayList<>();
        for (int i = 1; i <= tokensNumber; i++)
            tokens.add(new Token(i));
    }

    public synchronized Token extractToken(@NotNull Player player) {
        Token givenToken = null;
        try {
            this.notify();
            while (player.getMyTurn() != game.getTurn()) {
                this.wait(10);
            }
            if (tokensNumber == 0 || game.getStop()) {
                this.notifyAll();
                game.setTurn();
                return null;
            }
            System.out.println("Turn of player: " + player.getName() + "!");
            givenToken = tokens.get(new Random().nextInt(tokensNumber));
            System.out.println("Turn of player: " + player.getName() + " has ended!\n");
            game.setTurn();
            tokens.remove(givenToken);
        } catch (Exception ignored) {
            System.out.println("Crapa ?");
        }
        return givenToken;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Boolean isEmpty() {
        return game.setStop(tokensNumber == 0);
    }
}
