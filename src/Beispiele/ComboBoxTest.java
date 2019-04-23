package Beispiele;

// Datei: ComboBoxTest.java

import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxTest extends JFrame implements ActionListener {
    private JComboBox<String> auswahl;
    private String[] items = { "rot", "gelb", "gruen" };
    private Color[] colors = { Color.red, Color.yellow,
            Color.green };
    private Container c;

    public ComboBoxTest() {
        super("Einzeiliges Listenfeld");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = getContentPane();
        c.setLayout(new FlowLayout());

        auswahl = new JComboBox<String>(items);
        auswahl.addActionListener(this);

        // 1. Listenelement vorausgewählt
        auswahl.setSelectedIndex(0);
        c.add(auswahl);

        setSize(400, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int i = auswahl.getSelectedIndex();
        c.setBackground(colors[i]);
    }

    public static void main(String[] args) {
        new ComboBoxTest();
    }
}
