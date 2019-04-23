package Beispiele;

// Datei: ListTest.java

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListTest extends JFrame implements ActionListener
{
    private JButton ok;
    private JList<String> auswahl;
    private String[] items = { "Java", "C++", "C#", "C",
            "Delphi", "Ada", "Python", "Ruby", "PHP" };


    public ListTest() {
        super("Mehrzeiliges Listenfeld");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        auswahl = new JList<String>(items);
        auswahl.setVisibleRowCount(6);
        auswahl.setSelectionBackground(Color.yellow);
        auswahl.setSelectionForeground(Color.red);
        c.add(new JScrollPane(auswahl));

        ok = new JButton("OK");
        ok.addActionListener(this);
        c.add(ok);

        setSize(400, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (auswahl.isSelectionEmpty())
            return;

        // Warum wird ein Feld verwendet?
        // Weil mehrere Zeilen selektiert werden können
        int[] idx = auswahl.getSelectedIndices();
        for (int i = 0; i < idx.length; i++)
            System.out.println(items[idx[i]]);
        System.out.println();
        auswahl.clearSelection();
    }

    public static void main(String[] args) {
        new ListTest();
    }
}