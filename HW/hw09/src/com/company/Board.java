package com.company;

public class Board {
    public String[][] board = { {" ", " ", " ", " "},
                                {" ", " ", " ", " "},
                                {" ", " ", " ", " "},
                                {" ", " ", " ", " "}, };

    public void drawBoard() {
        System.out.println(" _____ _____ _____ _____");
        System.out.println("|     |     |     |     |");
        System.out.format("|  %s  |  %s  |  %s  |  %s  |", board[0][0], board[0][1], board[0][2], board[0][3]);
        System.out.println(" ");
        System.out.println("|_____|_____|_____|_____|");
        System.out.println("|     |     |     |     |");
        System.out.format("|  %s  |  %s  |  %s  |  %s  |", board[1][0], board[1][1], board[1][1], board[1][1]);
        System.out.println(" ");
        System.out.println("|_____|_____|_____|_____|");
        System.out.println("|     |     |     |     |");
        System.out.format("|  %s  |  %s  |  %s  |  %s  |", board[2][0], board[2][1], board[2][2], board[2][3]);
        System.out.println(" ");
        System.out.println("|_____|_____|_____|_____|");
        System.out.println("|     |     |     |     |");
        System.out.format("|  %s  |  %s  |  %s  |  %s  |", board[3][0], board[3][1], board[3][2], board[3][3]);
        System.out.println(" ");
        System.out.println(" _____ _____ _____ _____");
    }

    public boolean spawnNumber() {
        boolean added = false;
        boolean stillSpace = true;
        while (added == false) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (!added && board[i][j].equals(" ") && Math.random() > 0.7) {
                        board[i][j] = "2";
                        added = true;
                        break;
                    } else if (!added && board[i][j].equals(" ") && Math.random() < 0.2) {
                        board[i][j] = "4";
                        added = true;
                        break;
                    }
                }
            }
            stillSpace = false;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (board[i][j].equals(" ")) {
                        stillSpace = true;
                    }
                }
            }
            if (stillSpace == false) {
                System.out.println("Board is full! You lose!");
                return false;
            }
        }
        return true;
    }
}
