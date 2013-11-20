/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import javax.swing.table.AbstractTableModel;
import entities.Invoice;
import java.util.ArrayList;
/**
 *
 * @author �����
 */
public class InvoiceModel extends AbstractTableModel{
    private ArrayList<Invoice> inv;
    private String[] columnNames = {"ID", "Клиент", "Дата"};
    
    public InvoiceModel(ArrayList<Invoice> inv) {
        super();
        this.inv = inv;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    @Override
    public int getRowCount() {
        if (inv == null)
            return 0;
        else
            return inv.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int r, int c) {
        if (inv == null)
            return null;
        if (r >= inv.size())
            return null;
        if (r < 0)
            return null;
        switch (c) {
        case 0:
            return inv.get(r).getId();
        case 1:
            return inv.get(r).getFirmName();
        case 2:
            return inv.get(r).getDate().substring(0, 10);
        default:
            return null;
        }
    }
    
}
