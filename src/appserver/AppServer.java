
package appserver;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.*;

public class AppServer {

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        //<Ня>
        try{
            Naming.rebind("RMIServer", new Server());
        }
        catch(Exception e){
            System.out.println("Error RMI_1: " +e);
        }
        //</Ня>
        
//        Connection con = null;
//        try {
//            con = oraConnect("nyasha", "nyasha");
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("Select goods_name from goods");
//            try {
//                while (rs.next()) {
//                    System.out.println(rs.getString(1));   // Print col 1
//                }
//            } finally {
//                try {
//                    rs.close();
//                } catch (Exception ignore) {
//                }
//            }
//            st.close();
//            con.close();
//        } catch (SQLException e) {
//            System.out.println("connection fail: " + e.toString());
//        }
// 
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
