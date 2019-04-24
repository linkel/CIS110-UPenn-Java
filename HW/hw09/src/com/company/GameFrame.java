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

    public void initializeBoard() {
        spawnNumber(2);
    }

    public boolean spawnNumber(int limit) {
        int added = 0;
        boolean stillSpace = true;
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

    public void repaintBoard()


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
        g.drawString("4", 77, 125);
        g.drawString("4", 212, 125);
        g.drawString("4", 342, 125);
        g.drawString("4", 477, 125);
        g.drawString("4", 77, 255);
        g.drawString("4", 212, 255);
        g.drawString("4", 342, 255);
        g.drawString("4", 477, 255);
        g.drawString("4", 77, 385);
        g.drawString("4", 212, 385);
        g.drawString("4", 342, 385);
        g.drawString("4", 477, 385);
        g.drawString("4", 77, 515);
        g.drawString("4", 212, 515);
        g.drawString("4", 342, 515);
        g.drawString("4", 477, 515);
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
