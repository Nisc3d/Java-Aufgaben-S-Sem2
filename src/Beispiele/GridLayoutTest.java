package Beispiele;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class GridLayoutTest extends JFrame {
    public GridLayoutTest() {
        super("GridLayout");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setBackground(Color.white);
        c.setLayout(new GridLayout(2, 3, 10, 10));

        for (int i = 1; i <= 5; i++)
            c.add(new MyPanel(i));

        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayoutTest();
    }
}
