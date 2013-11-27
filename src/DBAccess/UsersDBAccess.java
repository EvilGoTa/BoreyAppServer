/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class UsersDBAccess extends DBAccess{
    public Integer auth(String name, String pass) throws SQLException{
        Connection connection = getConnect();
        Statement stat = connection.createStatement();
        String query = "SELECT role FROM USERS WHERE login='"+name+"' AND password='"+pass+"'";
        ResultSet set = stat.executeQuery(query);
        while(set.next()){
            return set.getInt("role");
        }
        return 0;
    }
        
}
