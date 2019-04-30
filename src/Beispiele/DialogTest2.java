package Beispiele;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogTest2 extends JFrame
        implements ActionListener {

    public DialogTest2() {
        super("Dialog-Test 2");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JButton ende = new JButton("Ende");
        ende.addActionListener(this);
        c.add(ende);

        JButton ein = new JButton("Eingabe");
        ein.addActionListener(this);
        c.add(ein);

        JButton msg = new JButton("Mitteilung");
        msg.addActionListener(this);
        c.add(msg);
        setSize(300, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Ende")) {
            int n = JOptionPane.showConfirmDialog(this,
                    "Anwendung wirklich beenden?", "Ende",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (n == JOptionPane.YES_OPTION)
                System.exit(0);
        }
        else if (cmd.equals("Eingabe")) {
            String s = JOptionPane.showInputDialog(this,
                    "Bitte Kontonummer eingeben:", "Eingabe",
                    JOptionPane.PLAIN_MESSAGE);

            if (s != null)
                System.out.println(s);
        }
        else if (cmd.equals("Mitteilung")) {
            JOptionPane.showMessageDialog(this, "Das ist ein Test!",
                    "Mitteilung", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new DialogTest2();
    }
}
