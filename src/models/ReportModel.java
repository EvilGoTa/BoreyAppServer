/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.InvoiceReport;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Asus
 */
public class ReportModel extends AbstractTableModel {

    private ArrayList<InvoiceReport> data;
    private String[] columnNames = {"ID", "Клиент", "Задолжность"};
    
    public ReportModel(ArrayList<InvoiceReport> ir) {
        super();
        data = ir;
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
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
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
            return data.get(r).getFirm_id();
        case 1:
            return data.get(r).getFirm_name();
        case 2:
            return data.get(r).getSum();
        default:
            return null;
        }
    }
    
}
