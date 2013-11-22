
package models;

import entities.Account;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class AccountTableModel extends AbstractTableModel{
    private ArrayList<Account> acc = null;
    private String[] columnName = {"ID", "Фирма", "Валюта", "Банк", "Тип"};
    
    public AccountTableModel(ArrayList<Account> acc){
        super();
        this.acc = acc;
    }
    
    @Override
    public int getRowCount() {
        return acc.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch(c){
            case 0:
                return acc.get(r).getId();
            case 1:
                return acc.get(r).getFirm_id();
            case 2:
                return acc.get(r).getCurrency_id();
            case 3:
                return acc.get(r).getBank_id();
            case 4:
                return acc.get(r).getAccount_type();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }
    
}
