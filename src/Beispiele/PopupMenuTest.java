package Beispiele;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PopupMenuTest extends JFrame implements ActionListener, MouseListener {

    private JPopupMenu menu;

    public PopupMenuTest() {
        super("Kontextmenü-Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setBackground(Color.white);
        c.addMouseListener(this);
        buildMenu();
        setSize(400, 300);
        setVisible(true);
    }

    private void buildMenu() {
        menu = new JPopupMenu();

        JMenuItem cut = new JMenuItem("Ausschneiden",
                new ImageIcon(getClass().getResource("cut.gif")));
        cut.setActionCommand("cut");
        cut.addActionListener(this);
        menu.add(cut);

        JMenuItem copy = new JMenuItem("Kopieren",
                new ImageIcon(getClass().getResource("copy.gif")));
        copy.setActionCommand("copy");
        copy.addActionListener(this);
        menu.add(copy);

        JMenuItem paste = new JMenuItem("Einfügen",
                new ImageIcon(getClass().getResource("paste.gif")));
        paste.setActionCommand("paste");
        paste.addActionListener(this);
        menu.add(paste);

        JMenuItem delete = new JMenuItem("Löschen",
                new ImageIcon(getClass().getResource("delete.gif")));
        delete.setActionCommand("delete");
        delete.addActionListener(this);
        menu.add(delete);
    }

    public void mousePressed(MouseEvent e) {
        if (e.isPopupTrigger()) //Abfrage auf rechte Maustaste
            menu.show((Component) e.getSource(), e.getX(), e.getY());
    }

    public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger())
            menu.show((Component) e.getSource(), e.getX(), e.getY());
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }

    public static void main(String[] args) {
        new PopupMenuTest();
    }
}