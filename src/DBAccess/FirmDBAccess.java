/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import entities.Firm;
import java.sql.PreparedStatement;

/**
 *
 * @author Роман
 */
public class FirmDBAccess extends DBAccess{
    public ArrayList<Firm> getFirm() {
        ArrayList<Firm> list = new ArrayList<>();
        try {
            Connection connection = getConnect();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM FIRM");
            while(set.next()){
                list.add(new Firm(set.getInt("firm_id"), set.getString("firm_name"), 
                        set.getString("firm_country"), set.getString("firm_Address"), 
                        set.getInt("firm_license"), set.getString("firm_type")));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
        return list;
    }
    
    public void addFirm(Firm firm) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "INSERT INTO FIRM (firm_id, firm_name, firm_country, "
                    + "firm_address, firm_type) "
                    + "VALUES (?, ?, ?, ?, ?, ?)");
            prep.setInt(1, firm.getId());
            prep.setString(2, firm.getName());
            prep.setString(3, firm.getCountry());
            prep.setString(4, firm.getAddress());
            prep.setInt(5, firm.getLicense());
            prep.setString(6, firm.getType());            
            prep.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
    }
    
    public void editFirm(Firm firm) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "UPDATE FIRM SET firm_name=?, firm_country=?, "
                    + "fitm_address=?, firm_license=?, firm_type=? "
                    + "WHERE firm_id=?");
            prep.setInt(6, firm.getId());
            prep.setString(1, firm.getName());
            prep.setString(2, firm.getCountry());
            prep.setString(3, firm.getAddress());
            prep.setInt(4, firm.getLicense());
            prep.setString(5, firm.getType());
            prep.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
    }
    
    public void delFirm(Firm firm) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "DELETE FROM FIRM WHERE firm_id=?");
            prep.setInt(1, firm.getId());
            prep.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
    }
}
