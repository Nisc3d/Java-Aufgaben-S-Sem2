package Beispiele;



import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class TableTest1 extends JFrame {
    private JTable table;

    public TableTest1() {
        super("Tabellen-Test 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table = new JTable(new MyTableModel());
        add(new JScrollPane(table));
        setSize(400, 200);
        setVisible(true);
    }

    private class MyTableModel extends AbstractTableModel {
        private static final int ROWS = 40;
        private static final int COLS = 6;
        private String[][] data = new String[ROWS][COLS];

        public MyTableModel() {
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    data[i][j] = "Z " + i + ", S " + j;
                }
            }
        }

        public int getColumnCount() {
            return COLS;
        }

        public int getRowCount() {
            return ROWS;
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }
    }

    public static void main(String[] args) {
        new TableTest1();
    }
}
