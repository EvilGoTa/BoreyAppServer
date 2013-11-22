
package models;

import entities.Goods;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class GoodsTableModel extends AbstractTableModel{
    private ArrayList<Goods> goods;
    private String[] columnName = {"ID", "Название", "С.Качества", "Упаковка", "Производитель", "Кол-во", "Цена"};
    
    public GoodsTableModel(ArrayList<Goods> goods){
        super();
        this.goods=goods;
    }
    
    @Override
    public int getRowCount(){
        if (goods == null){
            return 0;
        }
        else
            return goods.size();
    }
    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
        case 0:
            return goods.get(r).getId();
        case 1:
            return goods.get(r).getName();
        case 2:
            return goods.get(r).getClass_num();
        case 3:
            return goods.get(r).getTara();
        case 4:
            return goods.get(r).getFirm_name();
        case 5:
            return goods.get(r).getCount();
        case 6:
            return goods.get(r).getPrice();
        default:
            return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }
    
}
