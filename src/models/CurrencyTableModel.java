
package models;

import entities.Currency;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class CurrencyTableModel extends AbstractTableModel{
    private ArrayList<Currency> currency = null;
    private String[] columnName = {"ID", "Название", "Страна", "Описание"};

    public CurrencyTableModel(ArrayList<Currency> curr){
        super();
        this.currency=curr;
    }
    
    @Override
    public int getRowCount() {
        if (currency==null){
            return 0;
        }
        else{
            return currency.size();
        }
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch(c){
            case 0:
                return currency.get(r).getId();
            case 1:
                return currency.get(r).getName();
            case 2:
                return currency.get(r).getCountry();
            case 3:
                return currency.get(r).getDesc();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }
    
}
