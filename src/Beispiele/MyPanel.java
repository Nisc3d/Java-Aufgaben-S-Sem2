package Beispiele;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class MyPanel extends JPanel {
    private int id;

    public MyPanel(int id) {
        this.id = id;
        setBackground(Color.lightGray);
        setPreferredSize(new Dimension(50, 50));
        setMaximumSize(new Dimension(50, 50));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(String.valueOf(id), 5, 15);
    }
}


