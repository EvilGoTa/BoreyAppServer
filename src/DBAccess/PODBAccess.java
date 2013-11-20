/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import entities.PaymentOrder;
import java.sql.PreparedStatement;

/**
 *
 * @author Роман
 */
public class PODBAccess extends DBAccess{
    public ArrayList<PaymentOrder> getPO() {
        ArrayList<PaymentOrder> list = new ArrayList<>();
        try {
            Connection connection = getConnect();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM PAYMENT_ORDER");
            while(set.next()){
                list.add(new PaymentOrder(set.getInt("po_department_id"), set.getInt("po_account_id"), 
                        set.getString("po_date"), set.getInt("po_total_amount"), 
                        set.getInt("po_invoice_id")));
            }
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
        return list;
    }
    
    public void addPO(PaymentOrder po) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "INSERT INTO PAYMENT_ORDER (po_department_id, po_account_id, po_date, "
                    + "po_total_amount, po_invoice_id) "
                    + "VALUES (?, ?, '?', ?, ?, ?)");
            prep.setInt(1, po.getDepartment_id());
            prep.setInt(2, po.getAccount_id());
            prep.setString(3, po.getDate());
            prep.setInt(4, po.getTotal_amount());
            prep.setInt(5, po.getInvoice_id());                        
            prep.executeUpdate();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
    }
    
    public void editPO(PaymentOrder po) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "UPDATE PAYMENT_ORDER SET po_account_id=?, po_date=?, "
                    + "po_total_amount=?, po_invoice_id=? "
                    + "WHERE po_department_id=?");
            prep.setInt(5, po.getDepartment_id());
            prep.setInt(1, po.getAccount_id());
            prep.setString(2, po.getDate());
            prep.setInt(3, po.getTotal_amount());
            prep.setInt(4, po.getInvoice_id());           
            prep.executeUpdate();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
    }
    
    public void delPO(PaymentOrder po) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "DELETE FROM PAYMENT_ORDER WHERE po_department_id=?");
            prep.setInt(1, po.getDepartment_id());
            prep.executeUpdate();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
    }
}
