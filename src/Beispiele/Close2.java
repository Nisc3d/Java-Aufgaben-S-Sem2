package Beispiele;

import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Close2 extends JFrame {
    private long start;
    public Close2() {
        super("Demo Ereignisbehandlung");

        addWindowListener(new MyWindowListener());
        addKeyListener(new MyKeyListener());

        setSize(400, 200);
        setVisible(true);
        start = System.currentTimeMillis();
    }

    private void printTime() {
        long end = System.currentTimeMillis();
        double time = (end - start) / 1000.;
        System.out.println
                ("Das Fenster war " + time + " Sekunden geoeffnet.");
    }

    private class MyWindowListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            printTime();
            System.exit(0);
        }
    }

    private class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                printTime();
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new Close2();
    }
}