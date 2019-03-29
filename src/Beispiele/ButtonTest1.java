package Beispiele;

// Datei: ButtonTest1.java

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ButtonTest1 extends JFrame implements
        ActionListener {
    private Container c;
    private JButton button;

    public ButtonTest1() {
        super("Button");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = getContentPane();
        c.setLayout(new FlowLayout());

        // Warum funktioniert die folgende Zeile meist nicht?
        Icon icon = new
                ImageIcon(getClass().getResource("cat.gif"));
        // Icon wird nicht gefunden!
        // Lösung: Verzeichnispfad mitgeben, „\\“ als Trennzeichen
        // oder:   Datei ins src-Verzeichnis des Projekts kopieren

        button = new JButton("Bitte klicken", icon);

        // Frage: Was ist ein ToolTip?
        // der erscheint, falls Maus über Button steht

        button.setToolTipText("Test");
        button.addActionListener(this);
        c.add(button);

        setSize(300, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Random random = new Random();

//  Farbe in RGB-Darstellung
        c.setBackground(new Color(random.nextInt(256),
                random.nextInt(256), random.nextInt(256)));
    }

    public static void main(String[] args) {
        new ButtonTest1();
    }
}