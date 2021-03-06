package Aufgabe5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clipboard extends JFrame implements ActionListener {

    private JButton copy, cut, paste;
    private JTextArea text;

    public Clipboard() {
        super("Clipboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        setPreferredSize(new Dimension(400, 400));
        c.setLayout(new BorderLayout());
        c.setBackground(Color.white);
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.setBackground(Color.gray);
        c.add(p);
        copy = new JButton("Copy");
        copy.addActionListener(this);
        p.add(copy);
        cut = new JButton("Cut");
        cut.addActionListener(this);
        p.add(cut);
        paste = new JButton("Paste");
        paste.addActionListener(this);
        p.add(paste);
        add(p, BorderLayout.NORTH);
        text = new JTextArea(20,80);
        text.setEditable(true);
        text.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(text), BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == copy){
            text.copy();
        }
        else if (obj == cut){
            text.cut();
        }
        else if (obj == paste){
            text.paste();
        }
    }

    public static void main(String[] args) {
        new Clipboard();
        new Clipboard();
        new Clipboard();
    }
}


