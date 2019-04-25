package com.company;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.awt.Font;
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

    public boolean isFirstLine(String s, int i, int j) {
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

    public void checkPath(String s, int i, int j) {

    }

    public void moveUp() {
        for (int i = 0; i < board.length; i++) {
            for (int j=0; j < board[0].length; j++) {
                if (board[i][j] != " " && !isFirstLine("up",i,j)) {
                    int new_i = i - 1;
                    int new_j = j;
                    if (board[new_i][new_j] == " ") {
                        // TODO if it's empty then it's okay to move it up, check another up if it's empty too until you can't anymore and move it, then get rid of the one on this space.
                        //TODO then next line should check if there's a number that's the same as current, if it is, then double that num and get rid of the one on this space
                    }
                }
            }
        }
    }
    public void keyPressed(KeyEvent e) {
        //System.out.println("you pressed a key");
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_W)
            System.out.println("you pressed W");
        else if(e.getKeyCode()== KeyEvent.VK_A)
            System.out.println("you pressed A");
        else if(e.getKeyCode()== KeyEvent.VK_S)
            System.out.println("you pressed S");
        else if(e.getKeyCode()== KeyEvent.VK_D)
            System.out.println("you pressed D");
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
