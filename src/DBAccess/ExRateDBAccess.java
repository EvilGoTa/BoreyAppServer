/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import entities.ExchangeRate;
import java.sql.PreparedStatement;

/**
 *
 * @author Роман
 */
public class ExRateDBAccess extends DBAccess{
    public ArrayList<ExchangeRate> getExRate() {
        ArrayList<ExchangeRate> list = new ArrayList<>();
        try {
            Connection connection = getConnect();
            Statement statement = connection.createStatement();
            String query = "select distinct ex_id, ex_currency_id_1, cur1.curr_name name1, "
                    + "ex_currency_id_2, cur2.curr_name name2, ex_date, ex_ratio "
                    + "from exchange_rate " 
                    + "left join currency cur1 on cur1.curr_id = exchange_rate.ex_currency_id_1 "
                    + "left join currency cur2 on cur2.curr_id = exchange_rate.ex_currency_id_2";
            ResultSet set = statement.executeQuery(query);
            while(set.next()){
                list.add(new ExchangeRate(set.getInt("ex_id"), set.getInt("ex_currency_id_1"), 
                        set.getInt("ex_currency_id_2"), set.getString("ex_date"), set.getFloat("ex_ratio"),
                        set.getString("name1"), set.getString("name2")));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " prblem: "+e.toString());
        }
        return list;
    }
    
    public void addExRate(ExchangeRate exrate) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "INSERT INTO Exchange_Rate (ex_id, ex_currency_id_1, ex_currency_id_2, "
                    + "ex_date, ex_ratio) "
                    + "VALUES (?, ?, ?, ?, ?)");
            prep.setInt(1, exrate.getId());
            prep.setInt(2, exrate.getCurrency_id_1());
            prep.setInt(3, exrate.getCurrency_id_2());
            prep.setString(4, exrate.getDate());
            prep.setFloat(5, exrate.getRatio());         
            prep.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " prblem: "+e.toString());
        }
    }
    
    public void editExRate(ExchangeRate exrate) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "UPDATE Exchange_Rate SET ex_currency_id_1=?, ex_currency_id_2=?, "
                    + "ex_date=?, ex_ratio=? "
                    + "WHERE ex_id=?");
            prep.setInt(5, exrate.getId());
            prep.setInt(1, exrate.getCurrency_id_1());
            prep.setInt(2, exrate.getCurrency_id_2());
            prep.setString(3, exrate.getDate());
            prep.setFloat(4, exrate.getRatio());
            prep.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " prblem: "+e.toString());
        }
    }
    
    public void delExRate(ExchangeRate exrate) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "DELETE FROM Exchange_Rate WHERE ex_id=?");
            prep.setInt(1, exrate.getId());
            prep.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " prblem: "+e.toString());
        }
    }
}
