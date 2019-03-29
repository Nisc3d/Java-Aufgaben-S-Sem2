package Beispiele;

// Datei: NullLayoutTest.java

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;

public class NullLayoutTest extends JFrame {

    public NullLayoutTest() {
        super("NullLayout");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Über getContentPane() wird ein Container bereitgestellt.
// In diesen können graphische Objekte aufgenommen werden.

        Container c = getContentPane();
        c.setBackground(Color.white);
        c.setLayout(null);

        MyPanel p1 = new MyPanel(1);
        MyPanel p2 = new MyPanel(2);

// Startposition, Breite, Höhe

        p1.setBounds(10, 10, 100, 100);
        p2.setBounds(120, 10, 100, 50);
        c.add(p1);
        c.add(p2);

        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NullLayoutTest();
    }
}
