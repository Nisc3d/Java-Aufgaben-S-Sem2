package Aufgabe1;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    public MyPanel() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(600, 400));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillRoundRect(20, 20, 400, 100, 15, 15);
        g.setColor(Color.black);
        g.setFont(new Font("Comic Sans MS", Font.ITALIC, 32));
        g.drawString("GUIs sind prima", 65, 80);
    }
}
