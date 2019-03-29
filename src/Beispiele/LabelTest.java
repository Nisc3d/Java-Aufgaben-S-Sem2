package Beispiele;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
public class LabelTest extends JFrame {
    public LabelTest() {
        super("Label");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.white);

        Icon icon = new
                ImageIcon(getClass().getResource("javalogo.gif"));

        String text = "<html><div align='right'> Grundkurs <br/> Java </div></html>";

        JLabel label = new JLabel(text, icon, JLabel.CENTER);
        label.setIconTextGap(14);
        label.setForeground(Color.blue);
        label.setFont(new Font("SansSerif", Font.BOLD, 24));
        c.add(label);

        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LabelTest();
    }
}
