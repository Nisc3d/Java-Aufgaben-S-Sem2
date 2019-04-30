package Beispiele;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogTest1 extends JFrame
        implements ActionListener {

    public DialogTest1() {
        super("Dialog-Test 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton login = new JButton("Login");
        login.addActionListener(this);
        c.add(login);
        setSize(300, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        LoginDialog dialog = new LoginDialog(this);
// Wenn das Dialogfenster geschlossen wird, geht es hier
// weiter.

        if (dialog.isOk())
            System.out.println(dialog.getPassword());
    }

    private class LoginDialog extends JDialog
            implements ActionListener {
        private JPasswordField pw;
        private boolean ok;

        public LoginDialog(JFrame owner) {
            super(owner, "Login", true);
            setLocationRelativeTo(owner);
            setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            Container c = getContentPane();
            c.setLayout(new FlowLayout());
            c.add(new JLabel("Kennwort: "));
            pw = new JPasswordField(15);
            c.add(pw);
            JButton ok = new JButton("OK");
            ok.addActionListener(this);
            c.add(ok);
            JButton abbr = new JButton("Abbrechen");
            abbr.addActionListener(this);
            c.add(abbr);
            setSize(300, 120);
            setResizable(false);
            setVisible(true);

        }

        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            ok = false;
            if (cmd.equals("OK")) {
                if (pw.getPassword().length == 0)
                    return;
                ok = true;
            }
            dispose();
        }

        public boolean isOk() {
            return ok;
        }

        public char[] getPassword() {
            return pw.getPassword();
        }
    }

    public static void main(String[] args) {
        new DialogTest1();
    }
}
