package Beispiele;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ButtonTest2 extends JFrame implements
        ActionListener {
    private JCheckBox oval;
    private JRadioButton red;
    private JRadioButton yellow;
    private JRadioButton green;

    public ButtonTest2() {
        super("Radiobuttons und eine Checkbox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        red = new JRadioButton("rot", true);
        // true bedeutet: Button ist ausgewählt

        yellow = new JRadioButton("gelb");
        green = new JRadioButton("grün");

        red.addActionListener(this);
        yellow.addActionListener(this);
        green.addActionListener(this);

        ButtonGroup bg = new ButtonGroup();
        bg.add(red);
        bg.add(yellow);
        bg.add(green);

        oval = new JCheckBox("oval", true);
        oval.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(red);
        panel.add(yellow);
        panel.add(green);
        panel.add(oval);

        add(panel, BorderLayout.NORTH);
        add(new MyPanel(), BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    private class MyPanel extends JPanel {
        public MyPanel() {
            setBackground(Color.white);
            setPreferredSize(new Dimension(500, 200));
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (red.isSelected())
                g.setColor(Color.red);
            else if (yellow.isSelected())
                g.setColor(Color.yellow);
            else if (green.isSelected())
                g.setColor(Color.green);
            else
                g.setColor(Color.white);

            int w = getSize().width;
            int h = getSize().height;

            if (oval.isSelected())
                g.fillOval(10, 10, w - 20, h - 20);
            else
                g.fillRect(10, 10, w - 20, h - 20);
        }
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public static void main(String[] args) {
        new ButtonTest2();
    }
}