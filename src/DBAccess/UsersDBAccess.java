
package DBAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsersDBAccess extends DBAccess{
    
    public int login(String login, String pass){
        try{
            Connection connection = getConnect();
            Statement statement = connection.createStatement();
            String query = "select user_role from users where user_login='"+login+"' and user_password ='"+pass+"'";
            ResultSet set = statement.executeQuery(query);
            if (!set.next()) return 0;
            int role = new Integer(set.getInt("user_role"));
            connection.close();
            return role;
        }
        catch(Exception e){
            System.out.println("UsersDBAccess: "+e);
            return 0;
        }
    }
    
}
