
package models;

import entities.Bank;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class BankTableModel extends AbstractTableModel{
    private ArrayList<Bank> bank = null;
    private String[] columnName = {"ID", "Название", "Адрес", "Страна", "№ лицензии"};
    
    public BankTableModel(ArrayList<Bank> bank){
        super();
        this.bank = bank;
    }
    
    @Override
    public int getRowCount() {
        if (bank == null){
            return 0;
        }
        else
            return bank.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }
    
    @Override
    public Object getValueAt(int r, int с) {
        switch(с) {
        case 0:
            return bank.get(r).getId();
        case 1:
            return bank.get(r).getName();
        case 2:
            return bank.get(r).getAddress();
        case 3:
            return bank.get(r).getLocation();
        case 4:
            return bank.get(r).getLicense_num();
        default:
            return null;
        }
    }
}
