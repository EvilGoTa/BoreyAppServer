/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import entities.Currency;
import java.sql.PreparedStatement;

/**
 *
 * @author Роман
 */
public class CurrencyDBAccess extends DBAccess{
    public ArrayList<Currency> getCurrency() {
        ArrayList<Currency> list = new ArrayList<>();
        try {
            Connection connection = getConnect();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM Currency");
            while(set.next()){
                list.add(new Currency(set.getInt("curr_id"), set.getString("curr_name"), 
                        set.getString("curr_country"), set.getString("curr_desc")));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("CurrencyDBA prblem: "+e.toString());
        }
        return list;
    }
    
    public void addCurrency(Currency curr) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "INSERT INTO Currency (curr_id, curr_name, curr_country, "
                    + "curr_desc) "
                    + "VALUES (?, ?, ?, ?)");
            prep.setInt(1, curr.getId());
            prep.setString(2, curr.getName());
            prep.setString(3, curr.getCountry());
            prep.setString(4, curr.getDesc());
            prep.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("CurrencyDBA prblem: "+e.toString());
        }
    }
    
    public void editCurrency(Currency curr) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "UPDATE Currency SET curr_name=?, curr_country=?, "
                    + "curr_desc=? "
                    + "WHERE curr_id=?");
            prep.setInt(4, curr.getId());
            prep.setString(1, curr.getName());
            prep.setString(2, curr.getCountry());
            prep.setString(3, curr.getDesc());
            prep.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("CurrencyDBA prblem: "+e.toString());
        }
    }
    
    public void delCurrency(Currency curr) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "DELETE FROM Currency WHERE curr_id=?");
            prep.setInt(1, curr.getId());
            prep.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " prblem: "+e.toString());
        }
    }
}
