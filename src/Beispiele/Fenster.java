package Beispiele;// Datei: Beispiele.Fenster.java

// import für awt- und swing-Bibliotheken 

import javax.swing.JFrame;
import java.awt.Cursor;

//  selbst erstelltes Beispiele.Fenster wird von JFrame abgeleitet
public class Fenster extends JFrame {

    public Fenster() {
        // verwende Konstruktor von JFrame für Titelzeile
        super("Einfaches Fenster");

        // Programmende beim Schließen des Fensters
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(400, 200); // Größe: Breite und Höhe
        setLocation(100, 100); // Position: linke obere Ecke
        setVisible(true); // Sichtbarkeit
    }

    public static void main(String[] args) {
        Fenster frame = new Fenster();

        // Anzeige verschiedener Cursor-Formen als int-Konstanten
        // insgesamt 6 Cursor-Formen werden vorgegeben

        int[] types = {Cursor.CROSSHAIR_CURSOR, Cursor.HAND_CURSOR,
                Cursor.MOVE_CURSOR, Cursor.TEXT_CURSOR,
                Cursor.WAIT_CURSOR, Cursor.DEFAULT_CURSOR};

// verkürzte for-Schleife
        // die oben definierten cursor werden nacheinander gezeigt
        for (int type : types) {

// Programm hält an für 3000 Millisekunden
// Fehlerbehandlung bei sleep() zwingend notwendig
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }

            // cursor wird ausgewählt
            Cursor c = Cursor.getPredefinedCursor(type);
            frame.setCursor(c);

            // Name des cursors als Titelzeile
            frame.setTitle(c.getName());
        }
    }
}

