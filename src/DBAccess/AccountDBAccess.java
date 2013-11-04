/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import entities.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class AccountDBAccess extends DBAccess{
    public ArrayList<Account> getAccounts() {
        ArrayList<Account> list = new ArrayList();
        try {
            Connection connection = getConnect();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM cars");
            while(set.next()){
                list.add(new Account(set.getInt("id"), set.getInt("firm_id"), 
                        set.getInt("currency_id"), set.getInt("bank_id"), 
                        set.getString("account_type")));
            }
        } catch (Exception e) {
            System.out.println("AccountDBA prblem: "+e.toString());
        }
        return list;
    }
    
    public void addAccount(Account account) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "INSERT INTO Account (acc_id, acc_firm_id, acc_currency_id, "
                    + "acc_bank_id, acc_account_type) "
                    + "VALUES (?, ?, ?, ?, '?')");
            prep.setInt(1, account.getId());
            prep.setInt(2, account.getFirm_id());
            prep.setInt(3, account.getCurrency_id());
            prep.setInt(4, account.getBank_id());
            prep.setString(5, account.getAccount_type());
            
            prep.executeUpdate();
        } catch (Exception e) {
            System.out.println("AccountDBA prblem: "+e.toString());
        }
    }
}
