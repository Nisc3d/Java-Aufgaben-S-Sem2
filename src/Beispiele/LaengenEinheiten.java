package Beispiele;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class LaengenEinheiten extends JFrame
        implements ActionListener {
    private JTextField eingabe, m, inch, foot, yard;
    private JComboBox<String> auswahl;
    private StringBuilder zahl;
    private String einheit;

    public LaengenEinheiten() {
        super("Längeneinheiten");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout(10, 10));
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 10));
        eingabe = new JTextField(20);
        eingabe.setHorizontalAlignment(JTextField.RIGHT);
        eingabe.setFont(new Font("Monospaced", Font.PLAIN, 18));
        p1.add(eingabe);
        String[] items = {"m", "inch", "foot", "yard"};
        auswahl = new JComboBox<String>(items);
        auswahl.setActionCommand("Auswahl");
        auswahl.addActionListener(this);
        p1.add(auswahl);
        c.add(p1, BorderLayout.NORTH);
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(4, 3, 5, 5));
        addButton(p2, "7");
        addButton(p2, "8");
        addButton(p2, "9");
        addButton(p2, "4");
        addButton(p2, "5");
        addButton(p2, "6");
        addButton(p2, "1");
        addButton(p2, "2");
        addButton(p2, "3");
        addButton(p2, "0");
        addButton(p2, ".");
        addButton(p2, "C");
        p2.setBorder(new EmptyBorder(0, 20, 0, 0));
        c.add(p2, BorderLayout.CENTER);
        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(4, 2, 10, 5));
        m = addField(p3, "m");
        inch = addField(p3, "inch");
        foot = addField(p3, "foot");
        yard = addField(p3, "yard");
        c.add(p3, BorderLayout.EAST);
        JPanel p4 = new JPanel();
        addButton(p4, "Berechnen");
        c.add(p4, BorderLayout.SOUTH);
        zahl = new StringBuilder();
        einheit = "m";
        pack();
        setVisible(true);
    }

    private void addButton(JPanel panel, String s) {
        JButton b = new JButton(s);
        b.addActionListener(this);
        panel.add(b);
    }

    private JTextField addField(JPanel panel, String s) {
        JTextField tf = new JTextField(20);
        tf.setHorizontalAlignment(JTextField.RIGHT);
        tf.setFont(new Font("Monospaced", Font.PLAIN, 12));
        tf.setEditable(false);
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
        p.add(tf);
        p.add(new JLabel(s));
        panel.add(p);
        return tf;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        zahl.setLength(0);
        zahl.append(eingabe.getText());

        if (cmd.compareTo("0") >= 0 && cmd.compareTo("9") <= 0) {
            zahl.append(cmd);
            eingabe.setText(zahl.toString());
        }
        else if (cmd.equals(".")) {
            if (zahl.toString().indexOf('.') == -1) {
                zahl.append(".");
                eingabe.setText(zahl.toString());
            }
        }
        else if (cmd.equals("C")) {
            zahl.setLength(0);
            eingabe.setText("");
        }
        else if (cmd.equals("Berechnen")) {
            m.setText("");
            inch.setText("");
            foot.setText("");
            yard.setText("");

            try {
                String s = zahl.toString().replace(',', '.');
                double val = Double.parseDouble(s);
                berechne(val, einheit);
            } catch (NumberFormatException ex) {
                zahl.setLength(0);
                eingabe.setText("");
            }
        }
        else if (cmd.equals("Auswahl")) {
            einheit = (String) auswahl.getSelectedItem();
            m.setText("");
            inch.setText("");
            foot.setText("");
            yard.setText("");
        }
    }

    private void berechne(double d, String e) {
        double erg;
        if (e.equals("m")) {
            erg = d;
            m.setText(formatiere(erg));
            erg = 1. / 0.0254 * d;
            inch.setText(formatiere(erg));
            erg = 1. / 0.3048 * d;
            foot.setText(formatiere(erg));
            erg = 1. / 0.9144 * d;
            yard.setText(formatiere(erg));
        }
        else if (e.equals("inch")) {
            erg = 0.0254 * d;
            m.setText(formatiere(erg));
            erg = d;
            inch.setText(formatiere(erg));
            erg = 1. / 12. * d;
            foot.setText(formatiere(erg));
            erg = 1. / 36. * d;
            yard.setText(formatiere(erg));
        }
        else if (e.equals("foot")) {
            erg = 0.3048 * d;
            m.setText(formatiere(erg));
            erg = 12 * d;
            inch.setText(formatiere(erg));
            erg = d;
            foot.setText(formatiere(erg));
            erg = 1. / 3. * d;
            yard.setText(formatiere(erg));
        }
        else if (e.equals("yard")) {
            erg = 0.9144 * d;
            m.setText(formatiere(erg));
            erg = 36 * d;
            inch.setText(formatiere(erg));
            erg = 3 * d;
            foot.setText(formatiere(erg));
            erg = d;
            yard.setText(formatiere(erg));
        }
    }

    private static String formatiere(double d) {
        DecimalFormat f = new DecimalFormat("0.0000");
        return f.format(d);
    }

    public static void main(String[] args) {
        new LaengenEinheiten();
    }
}
