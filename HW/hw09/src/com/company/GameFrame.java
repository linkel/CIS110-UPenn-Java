package com.company;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.awt.Font;
import java.util.Arrays;
import java.util.Random;

public class GameFrame extends JFrame implements KeyListener {

    public String[][] board = new String[][]{{" ", " ", " ", " "}, {" ", " ", " ", " "}, {" ", " ", " ", " "}, {" ", " ", " ", " "}};

    public Point[][] locations = new Point[][] {{new Point(77,125), new Point(212, 125), new Point(342, 125), new Point(477, 125)},
            {new Point(77,255), new Point(212, 255), new Point(342, 255), new Point(477, 255)},
            {new Point(77,385), new Point(212, 385), new Point(342, 385), new Point(477, 385)},
            {new Point(77,515), new Point(212, 515), new Point(342, 515), new Point(477, 515)}};


    public void drawBoard(Graphics g) {
        for (int i = 0; i < board.length; i++) {
            for (int j=0; j < board[0].length; j++) {
                g.drawString(board[i][j],(int)locations[i][j].getX(),(int)locations[i][j].getY());
            }
        }
    }

    public boolean spawnNumber(int limit) {
        int added = 0;
        Random generator = new Random();
        while (added < limit) {
            int randomI = generator.nextInt(board.length);
            int randomJ = generator.nextInt(board[0].length);
            int twoOrFour = generator.nextInt(10);
            if (board[randomI][randomJ].equals(" ") && twoOrFour > 3) {
                board[randomI][randomJ] = "2";
                added += 1;
            } else if (board[randomI][randomJ].equals(" ") && twoOrFour <= 3) {
                board[randomI][randomJ] = "4";
                added += 1;
            }
            if (!openSpacesLeft()) {
                System.out.println("Board is full! You lose!");
                return false;
            }
        }
        return true;
    }

    private boolean openSpacesLeft() {
        boolean stillSpace = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j].equals(" ")) {
                    stillSpace = true;
                }
            }
        }
        return stillSpace;
    }

    public boolean isFirstLine(String s, int i, int j) { // TODO this function can be rolled into the checkPath one
        switch(s) {
            case "up":
                if (i == 0) {
                    return true;
                }
                return false;
            case "left":
                if (j == 0) {
                    return true;
                }
                return false;
            case "right":
                if (j == 3) {
                    return true;
                }
                return false;
            case "down":
                if (i == 3) {
                    return true;
                }
                return false;
            default:
                System.out.println("Whoa! I messed up and didn't provide a string for the direction.");
        }
        return false;
    }

    public Point checkPath(String s, int i, int j) {
        String original;
        int new_i;
        int new_j;
        Point potential_space;
        switch (s) {
            case "up":
                original = board[i][j];
                new_i = i - 1;
                new_j = j;
                potential_space = new Point(j, i);
                while (new_i >= 0) {
                    if (board[new_i][new_j] == " " || board[new_i][new_j].equals(original)) {
                        potential_space = new Point(new_j, new_i);
                    }
                    new_i--;
                }
                return potential_space;
            case "down":
                original = board[i][j];
                new_i = i + 1;
                new_j = j;
                potential_space = new Point(j, i);
                while (new_i < 4) {
                    if (board[new_i][new_j] == " " || board[new_i][new_j].equals(original)) {
                        potential_space = new Point(new_j, new_i);
                    }
                    new_i++;
                }
                return potential_space;
            case "left":
                original = board[i][j];
                new_i = i;
                new_j = j - 1;
                potential_space = new Point(j, i);
                while (new_j >= 0) {
                    if (board[new_i][new_j] == " " || board[new_i][new_j].equals(original)) {
                        potential_space = new Point(new_j, new_i);
                    }
                    new_j--;
                }
                return potential_space;
            case "right":
                original = board[i][j];
                new_i = i;
                new_j = j + 1;
                potential_space = new Point(j, i);
                while (new_j < 4) {
                    if (board[new_i][new_j] == " " || board[new_i][new_j].equals(original)) {
                        potential_space = new Point(new_j, new_i);
                    }
                    new_j++;
                }
                return potential_space;
        }
        potential_space = new Point(9,9); // TODO please throw an exception here or something
        return potential_space;
    }

    public String checkResult(Point newLocation, String originalValue, Point oldLocation) {
        if ((newLocation.getX() != oldLocation.getX() || newLocation.getY() != oldLocation.getY())
                && board[(int) newLocation.getY()][(int) newLocation.getX()].equals(originalValue)) {
            int result = Integer.parseInt(originalValue)*2;
            if (result == 2048) {
               System.out.println("You win!");
            }
            return String.valueOf(result);
        }
        return originalValue;
    }

    public void moveUp() {
        for (int i = 0; i < board.length; i++) {
            for (int j=0; j < board[0].length; j++) {
                if (board[i][j] != " ") {
                    Point moveTo = checkPath("up", i, j);
                    String result = checkResult(moveTo, board[i][j], new Point(j,i));
                    board[i][j] = " ";
                    board[(int) moveTo.getY()][(int) moveTo.getX()] = result;

                }
            }
        }
        spawnNumber(1);
        repaint();
    }

    public void moveDown() {
        for (int i = 3; i >= 0; i--) {
            for (int j = 3; j >= 0; j--) {
                if (board[i][j] != " ") {
                    Point moveTo = checkPath("down", i, j);
                    String result = checkResult(moveTo, board[i][j], new Point(j,i));
                    board[i][j] = " ";
                    board[(int) moveTo.getY()][(int) moveTo.getX()] = result;

                }
            }
        }
        spawnNumber(1);
        repaint();
    }

    public void moveLeft() {
        for (int j = 0; j < board.length; j++) {
            for (int i=0; i < board[0].length; i++) {
                if (board[i][j] != " ") {
                    Point moveTo = checkPath("left", i, j);
                    String result = checkResult(moveTo, board[i][j], new Point(j,i));
                    board[i][j] = " ";
                    board[(int) moveTo.getY()][(int) moveTo.getX()] = result;

                }
            }
        }
        spawnNumber(1);
        repaint();
    }

    public void moveRight() {
        for (int j = 3; j >= 0; j--) {
            for (int i = 0; i < board[0].length; i++) {
                if (board[i][j] != " ") {
                    Point moveTo = checkPath("right", i, j);
                    String result = checkResult(moveTo, board[i][j], new Point(j,i));
                    board[i][j] = " ";
                    board[(int) moveTo.getY()][(int) moveTo.getX()] = result;

                }
            }
        }
        spawnNumber(1);
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        //System.out.println("you pressed a key");
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_W) {
            moveUp();
            System.out.println((Arrays.deepToString(board)));
        }
        else if(e.getKeyCode()== KeyEvent.VK_A) {
            moveLeft();
            System.out.println((Arrays.deepToString(board)));
        }
        else if(e.getKeyCode()== KeyEvent.VK_S) {
            moveDown();
            System.out.println((Arrays.deepToString(board)));
        }
        else if(e.getKeyCode()== KeyEvent.VK_D) {
            moveRight();
            System.out.println((Arrays.deepToString(board)));
        }
    }

    public void keyTyped(KeyEvent e) {
        //System.out.println("what even is the difference");
    }

    public GameFrame() { // constructor
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        spawnNumber(2);
    }

    public void paint(Graphics g) {
        super.paint(g);

        drawSquare(g, 50, 50, 100, 100);
        drawSquare(g, 185, 50, 100, 100);
        drawSquare(g, 315, 50, 100, 100);
        drawSquare(g, 450, 50, 100, 100);
        drawSquare(g, 50, 180, 100, 100);
        drawSquare(g, 185, 180, 100, 100);
        drawSquare(g, 315, 180, 100, 100);
        drawSquare(g, 450, 180, 100, 100);
        drawSquare(g, 50, 310, 100, 100);
        drawSquare(g, 185, 310, 100, 100);
        drawSquare(g, 315, 310, 100, 100);
        drawSquare(g, 450, 310, 100, 100);
        drawSquare(g, 50, 440, 100, 100);
        drawSquare(g, 185, 440, 100, 100);
        drawSquare(g, 315, 440, 100, 100);
        drawSquare(g, 450, 440, 100, 100);

        Font currentFont = g.getFont();
        Font biggerFont = currentFont.deriveFont(70F);
        g.setFont(biggerFont);
        drawBoard(g);
    }

    public void drawSquare(Graphics g, int i, int i1, int i2, int i3) {
        g.drawRect(i, i1, i2, i3);
        g.setColor(Color.yellow);
        g.fillRect(i, i1, i2, i3);
        g.setColor(Color.black);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GameFrame frame = new GameFrame();
                frame.setTitle("2048 - Kelly Edition");
                frame.setResizable(false);
                frame.setSize(600, 600);
                frame.setMinimumSize(new Dimension(600, 600));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
