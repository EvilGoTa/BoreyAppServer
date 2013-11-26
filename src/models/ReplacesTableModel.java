
package models;

import entities.Replaces;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ReplacesTableModel extends AbstractTableModel{
    private ArrayList<Replaces> repl = null;
    private String columnName[] = {"Товар 1", "Товар 2"};
    
    public ReplacesTableModel(ArrayList<Replaces> repl){
        super();
        this.repl = repl;
    }
    
    @Override
    public int getRowCount() {
        return repl.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch(c){
            case 0:
                return repl.get(r).getName1();
            case 1:
                return repl.get(r).getName2();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }
    
}
