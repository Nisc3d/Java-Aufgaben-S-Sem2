package Beispiele;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextTest1 extends JFrame implements
        ActionListener {
    private JTextField artikel, preis;
    private JLabel msg1, msg2;
    private JButton ok;

    public TextTest1() {
        super("Clipboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new GridLayout(7, 1, 0, 0));

        c.add(new JLabel("Artikel:"));
        artikel = new JTextField(30); // 30 ist die Feldlänge

        // Eingabe wird überprüft / verifiziert
        artikel.setInputVerifier(new InputVerifier() {
            public boolean verify(JComponent input) {
                return isNotEmpty((JTextField) input);
            }
        });
        c.add(artikel);

        msg1 = new JLabel();
        msg1.setForeground(Color.red);
        c.add(msg1);

        c.add(new JLabel("Preis:"));
        preis = new JTextField(30);

        // Eingabe beginnt rechts im Feld
        preis.setHorizontalAlignment(JTextField.RIGHT);
        preis.setInputVerifier(new InputVerifier() {
            public boolean verify(JComponent input) {
                return isDouble((JTextField) input);
            }
        });
        c.add(preis);

        msg2 = new JLabel();
        msg2.setForeground(Color.red);
        c.add(msg2);

        ok = new JButton("OK");
        ok.addActionListener(this);
        c.add(ok);

        pack();
        setVisible(true);
    }

    private boolean isNotEmpty(JTextField f) {
        String s = f.getText().trim();
        if (s.length() == 0) {
            msg1.setText("Bitte die Artikelbezeichnung eingeben.");
            return false;
        }
        else {
            msg1.setText("");
            return true;
        }
    }

    private boolean isDouble(JTextField f) {
        String s = f.getText().trim();
        try {
            Double.parseDouble(s.trim());
            msg2.setText("");
            return true;
        } catch (NumberFormatException ex) {
            msg2.setText("Bitte eine Zahl eingeben.");
            return false;
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (isNotEmpty(artikel) && isDouble(preis)) {
            System.out.println("Artikel: " +
                    artikel.getText() + ", Preis: "
                    + preis.getText());
            artikel.setText("");
            preis.setText("");
        }
    }

    public static void main(String[] args) {
        new TextTest1();
    }
}
