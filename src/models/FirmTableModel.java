
package models;

import entities.Firm;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class FirmTableModel extends AbstractTableModel{
    private ArrayList<Firm> firm = null;
    private String columnName[] = {"ID", "Название", "Страна", "Адрес", "Лицензия", "Тип"};
    
    public FirmTableModel(ArrayList<Firm> firm){
        super();
        this.firm=firm;
    }
    
    @Override
    public int getRowCount() {
        return firm.size();
    }
    
    @Override
    public int getColumnCount() {
        return 6;
    }
    
    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }
    
    @Override
    public Object getValueAt(int r, int c) {
        switch(c){
            case 0:
                return firm.get(r).getId();
            case 1:
                return firm.get(r).getName();
            case 2:
                return firm.get(r).getCountry();
            case 3:
                return firm.get(r).getAddress();
            case 4:
                return firm.get(r).getLicense();
            case 5:
                return firm.get(r).getType();
            default:
                return null;
        }
    }
    
}
