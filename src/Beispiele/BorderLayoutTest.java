package Beispiele;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class BorderLayoutTest extends JFrame {
    public BorderLayoutTest() {
        super("BorderLayout");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setBackground(Color.white);
        c.setLayout(new BorderLayout(10, 10));

        c.add(new MyPanel(1), BorderLayout.NORTH);
        c.add(new MyPanel(2), BorderLayout.WEST);
        c.add(new MyPanel(3), BorderLayout.CENTER);
        c.add(new MyPanel(4), BorderLayout.EAST);
        c.add(new MyPanel(5), BorderLayout.SOUTH);

        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BorderLayoutTest();
    }
}
