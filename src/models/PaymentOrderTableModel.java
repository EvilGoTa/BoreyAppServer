
package models;

import entities.PaymentOrder;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class PaymentOrderTableModel extends AbstractTableModel{
    private ArrayList<PaymentOrder> payOrd = null;
    private String columnName[] = {"ID", "Счет", "Дата", "Сумма", "Накладная"};
    
    public PaymentOrderTableModel(ArrayList<PaymentOrder> payOrd){
        super();
        this.payOrd = payOrd;
    }
    
    @Override
    public int getRowCount() {
        return payOrd.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch(c){
            case 0:
                return payOrd.get(r).getDepartment_id();
            case 1:
                return payOrd.get(r).getAccount_id();
            case 2:
                return payOrd.get(r).getDate();
            case 3:
                return payOrd.get(r).getTotal_amount();
            case 4:
                return payOrd.get(r).getInvoice_id();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }    
    
}
