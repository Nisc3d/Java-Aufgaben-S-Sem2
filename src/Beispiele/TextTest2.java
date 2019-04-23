package Beispiele;

// Datei: TextTest2.java

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextTest2 extends JFrame implements ActionListener {
    private JButton print;
    private JTextArea area;

    public TextTest2() {
        super("Textfläche");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel top = new JPanel();
        print = new JButton("Drucken");
        print.addActionListener(this);
        top.add(print);
        add(top, BorderLayout.NORTH);

        area = new JTextArea(10, 50);
        // 10 Zeilen, 50 Spalten

        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        area.setFont(new Font("DialogInput",
                Font.PLAIN, 18));
        JScrollPane pane = new JScrollPane(area,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(pane, BorderLayout.CENTER);

        pack();
        area.requestFocusInWindow();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Runnable printTask = new Runnable() {
            public void run() {
                try {
                    area.print();
                } catch (PrinterException ex) {
                    System.out.println(ex);
                }
            }
        };
        new Thread(printTask).start();
    }

    public static void main(String[] args) {
        TextTest2 t = new TextTest2();
        t.area.requestFocusInWindow();
    }
}