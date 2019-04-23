package Aufgabe1;

import javax.swing.*;

public class Zeichnen extends JFrame {
    public Zeichnen() {
        super("TestGui");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new MyPanel());
        pack();
        setVisible(true);
    }
}