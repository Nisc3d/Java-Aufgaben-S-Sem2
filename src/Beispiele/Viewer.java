package Beispiele;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Viewer
        extends JFrame
        implements ActionListener {
    private JTextArea text;

    public Viewer() {
        super("Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel top = new JPanel();
        JButton open = new JButton("Öffnen");
        open.addActionListener(this);
        top.add(open);
        add(top, BorderLayout.NORTH);
        text = new JTextArea(20, 80);
        text.setEditable(false);
        text.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(text), BorderLayout.CENTER);
        pack();
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("."));
        fc.setFileFilter(new MyFileFilter());
        if (fc.showOpenDialog(this) ==
                JFileChooser.APPROVE_OPTION) {
            load(fc.getSelectedFile());
        }
    }

    private void load(File file) {
        try {
            text.read(new FileReader(file), null);
        } catch (IOException e) {
            text.setText(e.getMessage());
        }
    }

    private class MyFileFilter extends FileFilter {
        public boolean accept(File file) {
            if (file.isDirectory())
                return true;
            String name = file.getName();
            if (name.endsWith(".java"))
                return true;
            else if (name.endsWith(".txt"))
                return true;
            else
                return false;
        }

        public String getDescription() {
            return "Text file (*.java,*.txt)";
        }
    }

    public static void main(String[] args) {
        new Viewer();
    }
}