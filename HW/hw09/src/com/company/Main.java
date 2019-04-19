package com.company;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{
	// write your code here
        System.out.println("Welcome to a spiffy game!");
        gameLoop();
    }

    private static void gameLoop() throws IOException {
        Board board = new Board();
        boolean gameOngoing = true;
        int userInput = 'p';
        while (userInput != 'q' && gameOngoing) {
        System.out.println("Press a key!");
        userInput = System.in.read();
        gameOngoing = board.spawnNumber();
        board.drawBoard();
        }
    }
}
