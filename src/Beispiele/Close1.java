package Beispiele;

import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Close1 extends JFrame
        implements WindowListener, KeyListener {

// Es wird unterschieden zwischen im Fenster und durch Tasten
// ausgelöste Ereignisse

    private long start;

    public Close1() {
        super("Demo Ereignisbehandlung");
        // Registrierung
//
// das aktuelle Fenster reagiert auf Ereignisse aus dem
// Fenster (Window) und auf bestimmte Tasteneingaben (Key)
        addWindowListener(this);
        addKeyListener(this);
        setSize(400, 200);
        setVisible(true);

// ermittle aktuelle Uhrzeit in Millisekunden
// beim Öffnen des Fensters
        start = System.currentTimeMillis();
    }

    private void printTime() {
        long end = System.currentTimeMillis();
// ermittle Zeitdifferenz und gib sie aus
        double time = (end - start) / 1000.;
        System.out.println
                ("Das Fenster war " + time + " Sekunden geoeffnet.");
    }

    // Es folgen WindowListener-Methoden
// die Methode wird aufgerufen, wenn Fenster geschlossen wird
    public void windowClosing(WindowEvent e) {
        printTime();
        System.exit(0);
    }

    // Die folgenden Methoden sind im Interface WindowListener
// vorgesehen, werden aber hier nicht benötigt und deshalb
// „leer“ implementiert.
    public void windowActivated(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowOpened(WindowEvent e) {
    }

    // Jetzt folgen die KeyListener-Methoden
    public void keyPressed(KeyEvent e) {
// Reaktion nur, falls Escape-Taste gedrückt
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            printTime();
            System.exit(0);
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        new Close1();
    }
}