package com.compulsory;

import java.util.List;
import java.util.Random;

public class Board {
    private int tokenNumber;
    private List<Token> tokens;


    Board(int tokenNumber) {
        this.tokenNumber = tokenNumber;
        for(int i = 1; i<=tokenNumber; ++i) {
            tokens.add(new Token(i));
        }
    }


    public Token extract() {
        return tokens.get(new Random().nextInt()*1000%tokenNumber);
    }
}
