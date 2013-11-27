/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import java.sql.*;

/**
 *
 * @author Asus
 */
public class DBAccess {
    public Connection getConnect() throws SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            //Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            System.out.println("magic words didnt help: "+e.toString());
        }
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "nyasha", "nyasha");
        return con; 
    }
    
}
