package Beispiele;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
public class Kacheln extends JFrame implements ActionListener
{
    private JPanel[] panels;
    private JButton colors;
    private JButton reset;
    public Kacheln() {
        super("Kacheln");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel kacheln = new JPanel();
        kacheln.setPreferredSize(new Dimension(400, 400));
        kacheln.setBackground(Color.lightGray);
        kacheln.setLayout(new GridLayout(7, 7, 1, 1));
        panels = new JPanel[49];
        for (int i = 0; i < 49; i++) {
            panels[i] = new JPanel();
            panels[i].addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    JPanel p = (JPanel) e.getSource();
                    p.setBackground(getRandomColor());
                }
            });
            kacheln.add(panels[i]);
        }
        reset();
        add(kacheln, BorderLayout.CENTER);
        JPanel p = new JPanel();
        colors = new JButton("Farben");
        colors.addActionListener(this);
        p.add(colors);
        reset = new JButton("Zurücksetzen");
        reset.addActionListener(this);
        p.add(reset);
        add(p, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
    private Color getRandomColor() {
        Random random = new Random();
        return new Color(random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256));
    }
    private void setColors() {
        for (int i = 0; i < 49; i++) {
            panels[i].setBackground(getRandomColor());
        }
    }
    private void reset() {
        for (int i = 0; i < 49; i++) {
            panels[i].setBackground(Color.white);
        }
    }
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == colors)
            setColors();
        else
            reset();
    }
    public static void main(String[] args) {
        new Kacheln();
    }
}
