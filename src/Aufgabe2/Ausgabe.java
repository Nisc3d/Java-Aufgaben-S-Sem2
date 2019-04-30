package Aufgabe2;

import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ausgabe extends JFrame {

    public Ausgabe() {
        super("Demo Ereignisbehandlung");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new MyKeyListener());

        setSize(400, 200);
        setVisible(true);
        System.out.println("Fenster ist offen");
    }

    private class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_A) {
                System.out.println("A");
            }
            else if (e.getKeyCode() == KeyEvent.VK_E) {
                System.out.println("E");
            }
            else if (e.getKeyCode() == KeyEvent.VK_I) {
                System.out.println("I");
            }
            else if (e.getKeyCode() == KeyEvent.VK_O) {
                System.out.println("O");
            }
            else if (e.getKeyCode() == KeyEvent.VK_U) {
                System.out.println("U");
            }
        }
    }

    public static void main(String[] args) {
        new Ausgabe();
    }
}
