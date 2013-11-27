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
import entities.InvoiceReport;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            String query = "select inv_id, inv_firm_id, firm_name, inv_creation_date "
                    + "from invoice, firm "
                    + "WHERE firm.firm_id = invoice.inv_firm_id";
            ResultSet set = statement.executeQuery(query);
            while(set.next()){
                list.add(new Invoice(set.getInt("inv_id"), set.getString("inv_creation_date"), 
                        set.getInt("inv_firm_id"), set.getString("firm_name")));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
        return list;
    }
    
    public ArrayList<InvoiceReport> getReport() throws SQLException {
        ArrayList<InvoiceReport> reportList = new ArrayList();
        Connection connection = getConnect();
        Statement statement = connection.createStatement();
        String query = 
                "select firm.firm_name, sum(goods.goods_price*goods_in_inv.gin_goods_count) s from invoice " +
                "left join firm on firm.firm_id = invoice.inv_firm_id " +
                "left join goods_in_inv on goods_in_inv.gin_inv_id = invoice.inv_id " +
                "left join goods on goods.goods_id = goods_in_inv.gin_goods_id " +
                "where inv_id not in (select distinct po_invoice_id from payment_order) " +
                "group by firm.firm_name";
        ResultSet set = statement.executeQuery(query);
            while(set.next()){
                reportList.add(new InvoiceReport(0, set.getString("firm_name"), 
                        set.getInt("s")));
            }
            connection.close();
        return reportList;
    }
    
    public void addInvoice(Invoice inv) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "INSERT INTO INVOICE (inv_id, inv_creation_date, inv_firm_id) "                    
                    + "VALUES (?, ?, ?)");
            prep.setInt(1, inv.getId());
            prep.setString(2, inv.getDate());
            prep.setInt(3, inv.getFirm_id());                                 
            prep.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
    }
    
    public void editInvoice(Invoice inv) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "UPDATE INVOICE SET inv_creation_date=?, inv_firm_id=?, "
                    + ""
                    + "WHERE inv_id=?");
            prep.setInt(3, inv.getId());
            prep.setString(1, inv.getDate());
            prep.setInt(2, inv.getFirm_id());
            prep.executeUpdate();
            connection.close();
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
            connection.close();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
    }
}
