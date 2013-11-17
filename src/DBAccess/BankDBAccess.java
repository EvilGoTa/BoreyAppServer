/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import entities.Bank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Роман
 */
public class BankDBAccess extends DBAccess{
    public ArrayList<Bank> getBank() {
        ArrayList<Bank> list = new ArrayList();
        try {
            Connection connection = getConnect();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM bank");
            while(set.next()){
                list.add(new Bank(set.getInt("bank_id"), set.getString("bank_name"), 
                        set.getString("bank_address"), set.getString("bank_location"), 
                        set.getInt("bank_license_num")));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("BankDBA prblem: "+e.toString());
            
        }
        return list;
    }
    
    public void addBank(Bank bank) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "INSERT INTO BANK (bank_id, bank_name, bank_address, "
                    + "bank_location, bank_license_num) "
                    + "VALUES (?, ?, ?, ?, ?)");
            prep.setInt(1, bank.getId());
            prep.setString(2, bank.getName());
            prep.setString(3, bank.getAddress());
            prep.setString(4, bank.getLocation());
            prep.setInt(5, bank.getLicense_num());
            prep.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("BankDBA prblem: "+e.toString());
        }
    }
    
    public void editGoods(Bank bank) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "UPDATE BANK SET bank_name=?, bank_address=?, "
                    + "bank_location=?, bank_license_num=? "
                    + "WHERE bank_id=?");
            prep.setInt(5, bank.getId());
            prep.setString(1, bank.getName());
            prep.setString(2, bank.getAddress());
            prep.setString(3, bank.getLocation());
            prep.setInt(4, bank.getLicense_num());
            prep.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("BankDBA prblem: "+e.toString());
        }
    }
    
    public void delGoods(Bank bank) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "DELETE FROM BANK WHERE bank_id=?");
            prep.setInt(1, bank.getId());
            prep.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("BankDBA prblem: "+e.toString());
        }
    }
}
