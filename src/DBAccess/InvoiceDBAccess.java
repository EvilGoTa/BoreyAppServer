/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import entities.Invoice;
import java.sql.PreparedStatement;

/**
 *
 * @author Роман
 */
public class InvoiceDBAccess extends DBAccess{
    public ArrayList<Invoice> getInvoice() {
        ArrayList<Invoice> list = new ArrayList<>();
        try {
            Connection connection = getConnect();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM INVOICE");
            while(set.next()){
                list.add(new Invoice(set.getInt("inv_id"), set.getString("inv_creation_date"), 
                        set.getInt("inv_firm_id")));
            }
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
        return list;
    }
    
    public void addInvoice(Invoice inv) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "INSERT INTO INVOICE (inv_id, inv_creation_date, inv_firm_id) "                    
                    + "VALUES (?, '?', ?)");
            prep.setInt(1, inv.getId());
            prep.setString(2, inv.getDate());
            prep.setInt(3, inv.getFirm_id());
                                  
            prep.executeUpdate();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
    }
    
    public void editInvoice(Invoice inv) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "UPDATE INVOICE SET inv_creation_date='?', inv_firm_id=?, "
                    + ""
                    + "WHERE inv_id=?");
            prep.setInt(3, inv.getId());
            prep.setString(1, inv.getDate());
            prep.setInt(2, inv.getFirm_id());
            prep.executeUpdate();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
    }
    
    public void delInvoice(Invoice inv) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "DELETE FROM INVOICE WHERE inv_id=?");
            prep.setInt(1, inv.getId());
            prep.executeUpdate();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
    }
}
