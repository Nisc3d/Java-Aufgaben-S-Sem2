package Aufgabe1;

import javax.swing.*;

public class zeichnen extends JFrame {
    public zeichnen() {
        super("TestGui");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new MyPanel());
        pack();
        setVisible(true);
    }
}