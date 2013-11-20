/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import entities.GoodsInInv;
import java.sql.PreparedStatement;

/**
 *
 * @author Роман
 */
public class GoodsInInvDBAccess extends DBAccess{
    public ArrayList<GoodsInInv> getGIN() {
        ArrayList<GoodsInInv> list = new ArrayList<>();
        try {
            Connection connection = getConnect();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM GOODS_IN_INV");
            while(set.next()){
                list.add(new GoodsInInv(set.getInt("gin_goods_id"), set.getInt("gin_inv_id"), 
                        set.getInt("gin_goods_count"), set.getInt("valid")));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
        return list;
    }
    
    public ArrayList<GoodsInInv> getGIN(int invoice) {
        ArrayList<GoodsInInv> list = new ArrayList<>();
        try {
            Connection connection = getConnect();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM GOODS_IN_INV WHERE gin_inv_id = "+invoice);
            while(set.next()){
                list.add(new GoodsInInv(set.getInt("gin_goods_id"), set.getInt("gin_inv_id"), 
                        set.getInt("gin_goods_count"), set.getInt("valid")));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
        return list;
    }
    
    public void addGIN(GoodsInInv gin) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "INSERT INTO GOODS_IN_INV (gin_goods_id, gin_inv_id, gin_goods_count, "
                    + "valid) "
                    + "VALUES (?, ?, ?, ?)");
            prep.setInt(1, gin.getId());
            prep.setInt(2, gin.getInv_id());
            prep.setInt(3, gin.getGoods_count());
            prep.setInt(4, gin.getValid());                        
            prep.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
    }
    
    public void editGIN(GoodsInInv gin) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "UPDATE GOODS_IN_INV SET gin_inv_id=?, gin_goods_count=?, "
                    + "fitm_address=?, valid=? "
                    + "WHERE gin_goods_id=?");
            prep.setInt(4, gin.getId());
            prep.setInt(1, gin.getInv_id());
            prep.setInt(2, gin.getGoods_count());
            prep.setInt(3, gin.getValid());            
            prep.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
    }
    
    public void delGIN(GoodsInInv gin) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "DELETE FROM GOODS_IN_INV WHERE gin_goods_id=? AND gin_inv_id=?"); // 2 filds primary key
            prep.setInt(1, gin.getId());
            prep.setInt(2, gin.getInv_id());
            prep.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + " problem: "+e.toString());
        }
    }
}
