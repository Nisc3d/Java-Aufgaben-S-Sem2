package Beispiele;

// Datei: MausTest.java

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

public class MausTest extends JFrame {
    public MausTest() {
        super("Maus-Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new MyPanel());
        pack();
        setVisible(true);
    }

    private class MyPanel extends JPanel implements MouseListener, MouseMotionListener {

        // aktuelles, noch nicht gespeichertes Rechteck
        private Rect currentRect;

        // enthält alle komplett gezeichneten Rechtecke
        private Vector<Rect> rects = new Vector<Rect>();

        public MyPanel() {
            setBackground(Color.white);
            setPreferredSize(new Dimension(400, 300));
            addMouseListener(this);
            addMouseMotionListener(this);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // alle gespeicherten Rechtecke neu zeichnen
            for (Rect r : rects) {
                g.drawRect(r.x, r.y, r.b, r.h);
            }

            // aktuelles Rechteck zeichnen
            if (currentRect != null) {
                g.drawRect(currentRect.x, currentRect.y,
                        currentRect.b, currentRect.h);
            }
        }

        public void mousePressed(MouseEvent e) {
            // neues Rechteck erzeugen
            currentRect = new Rect(e.getX(), e.getY(), 0, 0);
        }

        public void mouseReleased(MouseEvent e) {
            // aktuelles Rechteck speichern
            if (currentRect.b > 0 && currentRect.h > 0)
                rects.add(currentRect);
        }

        public void mouseClicked(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseDragged(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();

            // Breite und Höhe des aktuellen Rechtecks
            // ermitteln
            if (x > currentRect.x && y > currentRect.y) {
                currentRect.b = x - currentRect.x;
                currentRect.h = y - currentRect.y;
            }

            repaint();
        }

        public void mouseMoved(MouseEvent e) {
        }


        private class Rect {
            private int x, y, b, h;

            public Rect(int x, int y, int b, int h) {
                this.x = x;
                this.y = y;
                this.b = b;
                this.h = h;
            }
        }
    }

    public static void main(String[] args) {
        new MausTest();
    }
}
