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
            String query = "select a.acc_id, a.acc_firm_id, f.firm_name, "
                + "a.acc_currency_id, c.curr_name, a.acc_bank_id, b.bank_name, a.acc_account_type "
                + "from account a, firm f, currency c, bank b " 
                + "where a.acc_bank_id = b.bank_id AND a.acc_currency_id = c.curr_id AND a.acc_firm_id = f.firm_id";
            ResultSet set = statement.executeQuery(query);
            while(set.next()){
                list.add(new Account(set.getInt("acc_id"), set.getInt("acc_firm_id"), 
                        set.getInt("acc_currency_id"), set.getInt("acc_bank_id"), 
                        set.getString("acc_account_type"), set.getString("firm_name"),
                        set.getString("curr_name"), set.getString("bank_name")));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("AccountDBA prblem: "+e.toString());
        }
        return list;
    }
    
    public int addAccount(Account account) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "INSERT INTO ACCOUNT (acc_id, acc_firm_id, acc_currency_id, "
                    + "acc_bank_id, acc_account_type) "
                    + "VALUES (?, ?, ?, ?, ?)");
            prep.setInt(1, account.getId());
            prep.setInt(2, account.getFirm_id());
            prep.setInt(3, account.getCurrency_id());
            prep.setInt(4, account.getBank_id());
            prep.setString(5, account.getAccount_type());
            
            prep.executeUpdate();
            connection.close();
            return 1;
        } catch (Exception e) {
            System.out.println("AccountDBA prblem: "+e.toString());
            return 0;
        }
    }
    
    public int editAccount(Account acc) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "UPDATE ACCOUNT SET acc_firm_id=?, acc_currency_id=?, "
                    + "acc_bank_id=?, acc_account_type=? "
                    + "WHERE acc_id=?");
            prep.setInt(5, acc.getId());
            prep.setInt(1, acc.getFirm_id());
            prep.setInt(2, acc.getCurrency_id());
            prep.setInt(3, acc.getBank_id());
            prep.setString(4, acc.getAccount_type());
            prep.executeUpdate();
            connection.close();
            return 1;
        } catch (Exception e) {
            System.out.println("BankDBA prblem: "+e.toString());
            return 0;
        }
    }
    
    public int deleteAccount(Account acc) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "DELETE FROM ACCOUNT WHERE acc_id=?");
            prep.setInt(1, acc.getId());
            prep.executeUpdate();
            connection.close();
            return 1;
        } catch (Exception e) {
            System.out.println("AccountDBA prblem: "+e.toString());
            return 0;
        }
    }
}
