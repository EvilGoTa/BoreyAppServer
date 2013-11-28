/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import java.util.ArrayList;
import entities.Goods;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Asus
 */
public class GoodsDBAccess extends DBAccess{
    
    public ArrayList<Goods> getGods() {
        ArrayList<Goods> goodsList = new ArrayList();
        try {
            Connection connection = getConnect();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM goods");
            while(set.next()){
                goodsList.add(new Goods(set.getInt("goods_id"), set.getString("goods_name"), 
                        set.getInt("goods_class_num"), set.getString("goods_tara"), 
                        set.getString("goods_firm_name"), set.getInt("goods_count"), 
                        set.getInt("goods_price")));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("GoodsDBA prblem: "+e.toString());
        }
        return goodsList;
    }
    
    public int addGoods(Goods goods) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "INSERT INTO GOODS (goods_id, goods_name, goods_class_num, "
                    + "goods_tara, goods_firm_name, goods_count, goods_price) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)");
            prep.setInt(1, goods.getId());
            prep.setString(2, goods.getName());
            prep.setInt(3, goods.getClass_num());
            prep.setString(4, goods.getTara());
            prep.setString(5, goods.getFirm_name());
            prep.setInt(6, goods.getCount());
            prep.setInt(7, goods.getPrice());
            prep.executeUpdate();
            connection.close();
            return 1;
        } catch (Exception e) {
            System.out.println("GoodsDBA prblem: "+e.toString());
            return 0;
        }
    }
    
    public int editGoods(Goods goods) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "UPDATE GOODS SET goods_name='?', goods_class_num=?, "
                    + "goods_tara='?', goods_firm_name='?', goods_count=?, "
                    + "goods_price=? "
                    + "WHERE goods_id=?");
            prep.setInt(7, goods.getId());
            prep.setString(1, goods.getName());
            prep.setInt(2, goods.getClass_num());
            prep.setString(3, goods.getTara());
            prep.setString(4, goods.getFirm_name());
            prep.setInt(5, goods.getCount());
            prep.setInt(6, goods.getCount());
            prep.executeUpdate();
            connection.close();
            return 1;
        } catch (Exception e) {
            System.out.println("GoodsDBA prblem: "+e.toString());
            return 0;
        }
    }
    
    public int delGoods(Goods goods) {
        try {
            Connection connection = getConnect();
            PreparedStatement prep = connection.prepareStatement(""
                    + "DELETE FROM GOODS WHERE goods_id=?");
            prep.setInt(1, goods.getId());
            prep.executeUpdate();
            connection.close();
            return 1;
        } catch (Exception e) {
            System.out.println("GoodsDBA prblem: "+e.toString());
            return 0;
        }
    }
}
