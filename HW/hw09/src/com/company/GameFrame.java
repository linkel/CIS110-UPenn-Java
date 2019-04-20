package com.company;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

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
