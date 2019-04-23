package com.company;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.awt.Font;

public class GameFrame extends JFrame implements KeyListener {

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
