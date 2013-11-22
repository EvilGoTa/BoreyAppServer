package models;

import entities.ExchangeRate;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ExRateTableModel extends AbstractTableModel{
    private ArrayList<ExchangeRate> exRate = null;
    private String[] columnName = {"ID", "Валюта 1", "Валюта 2", "Дата", "Курс"};
    
    public ExRateTableModel(ArrayList<ExchangeRate> nya){
        super();
        this.exRate = nya;
    }

    @Override
    public int getRowCount() {
        if (exRate==null){
            return 0;
        }
        else{
            return exRate.size();
        }
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch(c){
            case 0:
                return exRate.get(r).getId();
            case 1:
                return exRate.get(r).getCurrencyName1();
            case 2:
                return exRate.get(r).getCurrencyName2();
            case 3:
                return exRate.get(r).getDate();
            case 4:
                return exRate.get(r).getRatio().toString();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }
}
