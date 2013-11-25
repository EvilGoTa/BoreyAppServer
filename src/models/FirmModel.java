/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import entities.Firm;

/**
 *
 * @author Asus
 */
public class FirmModel extends AbstractTableModel{
    private ArrayList<Firm> data;
    private String[] columnNames = {"ID", "Название", "Страна", "Адрес", "Лицензия", "Тип"};
    
    public FirmModel(ArrayList<Firm> f) {
        data = f;
    }
    
    @Override
    public int getRowCount() {
        if (data == null) {
            return 0;
        } else {
            return data.size();
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int r, int c) {
        if (data == null)
            return null;
        if (r >= data.size())
            return null;
        if (r < 0)
            return null;
        switch (c) {
        case 0:
            return data.get(r).getId();
        case 1:
            return data.get(r).getName();
        case 2:
            return data.get(r).getCountry();
        case 3:
            return data.get(r).getAddress();
        case 4:
            return data.get(r).getLicense();
        case 5:
            return data.get(r).getType();
        default:
            return null;
        }
    }
    
}
