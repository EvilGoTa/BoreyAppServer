/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.GoodsInInv;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Asus
 */
public class GINModel extends AbstractTableModel{
    private ArrayList<GoodsInInv> gin;
    private String[] columnNames = {"ID inv", "ID good", "Товар", "Количество", "В наличии"};

    public GINModel(ArrayList<GoodsInInv> gin) {
        super();
        this.gin = gin;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    @Override
    public int getRowCount() {
        if (gin == null)
            return 0;
        else
            return gin.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int r, int c) {
        if (gin == null)
            return null;
        if (r >= gin.size())
            return null;
        if (r < 0)
            return null;
        //System.out.println("r = "+r+" size = "+gin.size());
        switch (c) {
        case 0:
            return gin.get(r).getInv_id();
        case 1:
            return gin.get(r).getId();    
        case 2:
            return gin.get(r).getGoodsName();
        case 3:
            return gin.get(r).getGoods_count();
        case 4:
            return gin.get(r).getValid();
        default:
            return null;
        }
    }
    
    
}
