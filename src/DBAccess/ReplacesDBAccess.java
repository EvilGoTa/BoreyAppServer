/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import entities.Goods;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import entities.Replaces;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Роман
 */
public class ReplacesDBAccess extends DBAccess{
    
    public ArrayList<Replaces> getReplaces() throws SQLException{
        ArrayList<Replaces> list = new ArrayList<>();
        Connection connection = getConnect();
        Statement statement = connection.createStatement();
        String query = "Select rep_good_id, g1.goods_name name1, rep_replace_good_id, g2.goods_name name2 "
            +"from replaces "
            +"left join goods g1 on g1.goods_id = replaces.rep_good_id "
            +"left join goods g2 on g2.goods_id = replaces.rep_replace_good_id";
        ResultSet set = statement.executeQuery(query);
        while(set.next()){
            list.add(new Replaces(set.getInt("rep_good_id"), set.getInt("rep_replace_good_id"),
                    set.getString("name1"), set.getString("name2")));
        }
        connection.close();
        return list;
    }
    
    public ArrayList<Replaces> getReplacesOf(Goods good) throws SQLException{
        ArrayList<Replaces> list = new ArrayList<>();
        Connection connection = getConnect();
        Statement statement = connection.createStatement();
        String id = good.getId().toString();
        String query = "Select rep_good_id, g1.goods_name name1, rep_replace_good_id, g2.goods_name name2 "
                + "from replaces "
                + "left join goods g1 on g1.goods_id = replaces.rep_good_id "
                + "left join goods g2 on g2.goods_id = replaces.rep_replace_good_id "
                + "where rep_good_id="+id
                + " or rep_replace_good_id="+id;
        ResultSet set = statement.executeQuery(query);
        while(set.next()){
            list.add(new Replaces(set.getInt("rep_good_id"), set.getInt("rep_replace_good_id"),
            set.getString("name1"), set.getString("name2")));
        }
        connection.close();
        return list;
    }
    
    public void addReplaces(Replaces rep) throws SQLException{
        Connection connection = getConnect();
        PreparedStatement prep = connection.prepareStatement(""
                + "INSERT INTO REPLACES (rep_good_id, rep_replace_good_id) "                    
                + "VALUES (?, ?)");
        prep.setInt(1, rep.getGood_id());            
        prep.setInt(2, rep.getReplace_good_id());                                  
        prep.executeUpdate();
        connection.close();
    }
    
    public void editReplaces(Replaces rep) throws SQLException{
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
        connection.close();
    }
    
    public void delReplaces(Replaces rep) throws SQLException{
        Connection connection = getConnect();
        PreparedStatement prep = connection.prepareStatement(""
                + "DELETE FROM REPLACES WHERE rep_good_id=? AND rep_replace_good_id=?"); // 2 fields primary key
        prep.setInt(1, rep.getGood_id());
        prep.setInt(2, rep.getReplace_good_id());
        prep.executeUpdate();
        connection.close();
    }
}
