package Beispiele;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class TableTest2
        extends JFrame
        implements TableModelListener {
    private JTable table;
    private MyTableModel model;
    private JLabel gesamt;

    public TableTest2() {
        super("Tabellen-Test 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model = new MyTableModel();
        model.addTableModelListener(this);
        table = new JTable(model);
        table.setPreferredScrollableViewportSize
                (new Dimension(400, 80));
        add(new JScrollPane(table), BorderLayout.CENTER);
        gesamt = new JLabel(model.update() + " ", JLabel.RIGHT);
        add(gesamt, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    public void tableChanged(TableModelEvent e) {
        gesamt.setText(model.update() + " ");
    }

    private class MyTableModel extends AbstractTableModel {
        private String[] colNames =
                { "Artikel", "Preis", "Menge", "Einzelsumme" };

        private Object[][] data = { { "A4711", 100, 10, 1000 },
                { "A4721", 80, 5, 400 }, { "A4731", 10, 20, 200 },
                { "A4741", 12, 5, 60 }, { "A4751", 250, 4, 1000 } };

        public int getColumnCount() {
            return colNames.length;
        }
        public int getRowCount() {
            return data.length;
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        public String getColumnName(int col) {
            return colNames[col];
        }

        public void setValueAt(Object value, int row, int col) {
            if (value == null)
                value = 0;
            data[row][col] = value;
            data[row][3] = (Integer) data[row][1] * (Integer)
                    data[row][2];
            fireTableDataChanged();
        }

        public boolean isCellEditable(int row, int col) {
            return (col == 1 || col == 2) ? true : false;
        }

        public Class<?> getColumnClass(int col) {
            if (col == 0)
                return String.class;
            else
                return Integer.class;
        }

        public int update() {
            int sum = 0;
            for (int i = 0; i < data.length; i++) {
                sum += (Integer) data[i][3];
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        new TableTest2();
    }
}
