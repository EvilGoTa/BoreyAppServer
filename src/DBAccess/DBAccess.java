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
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "gota", "gota");
        return con; 
    }
    
}
