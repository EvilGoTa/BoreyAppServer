/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appserver;

import DBAccess.GoodsDBAccess;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import remote.RemoteGoodsKeeper;
import roles.GoodsKeeper;

/**
 *
 * @author Asus
 */
public class AppServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Connection con = null;
        try {
            con = oraConnect("gota", "gota");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select goods_name from goods");
            try {
                while (rs.next()) {
                    System.out.println(rs.getString(1));   // Print col 1
                }
            } finally {
                try {
                    rs.close();
                } catch (Exception ignore) {
                }
            } 
            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("connection fail: " + e.toString());
        }*/
        
        /* rmi test */
        
        try {
            String name = "GoodsKeeper";
            GoodsKeeper gk = new GoodsKeeper();
            Naming.rebind(name, gk); 
            System.out.println("GoodsKeeper bound");
        } catch (Exception e) {
            System.out.println("error: "+e.toString());
            //e.printStackTrace();
        }
        
        /* --- */
        
    }
    
    public static Connection oraConnect(String username, String pass) throws SQLException{
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (Exception e) {
            System.out.println("magic words didnt help: "+e.toString());
        }
        
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", username, pass);
        return conn;
    }
}
