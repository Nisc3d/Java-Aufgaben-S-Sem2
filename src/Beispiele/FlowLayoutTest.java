package Beispiele;

// Datei: FlowLayoutTest.java

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

public class FlowLayoutTest extends JFrame {

    public FlowLayoutTest() {
        super("FlowLayout");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setBackground(Color.white);
        c.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        for (int i = 1; i <= 5; i++)
            c.add(new MyPanel(i));

        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayoutTest();
    }
}
