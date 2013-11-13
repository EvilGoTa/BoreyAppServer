/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import entities.Replaces;
import java.sql.PreparedStatement;

/**
 *
 * @author Роман
 */
public class ReplacesDBAccess extends DBAccess{
    public ArrayList<Replaces> getReplaces() {
        ArrayList<Replaces> list = new ArrayList<>();
        try {
            Connection connection = getConnect();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM REPLACES");
            while(set.next()){
                list.add(new Replaces(set.getInt("rep_good_id"), set.getInt("rep_replace_good_id")));
            }
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
        return list;
    }
    
    public void addReplaces(Replaces rep) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "INSERT INTO REPLACES (rep_good_id, rep_replace_good_id) "                    
                    + "VALUES (?, ?)");
            prep.setInt(1, rep.getGood_id());            
            prep.setInt(2, rep.getReplace_good_id());
                                  
            prep.executeUpdate();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
    }
    
    public void editReplaces(Replaces rep) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "UPDATE REPLACES SET rep_replace_good_id=?, rep_good_id=?, "
                    + ""
                    + "WHERE rep_good_id=? AND rep_replace_good_id=?");
            prep.setInt(2, rep.getGood_id());
            prep.setInt(1, rep.getReplace_good_id());
            prep.setInt(3, rep.getGood_id());
            prep.setInt(4, rep.getReplace_good_id());
            prep.executeUpdate();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
    }
    
    public void delReplaces(Replaces rep) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "DELETE FROM REPLACES WHERE rep_good_id=? AND rep_replace_good_id=?"); // 2 fields primary key
            prep.setInt(1, rep.getGood_id());
            prep.setInt(2, rep.getReplace_good_id());
            prep.executeUpdate();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
    }
}
