/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roles;

import DBAccess.UsersDBAccess;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import remote.RemoteLogin;

/**
 *
 * @author Asus
 */
public class Login extends UnicastRemoteObject implements RemoteLogin{

    public Login() throws RemoteException{
        super();
    }
    
    @Override
    public Integer tryLogin(String name, String pass) throws RemoteException {
        try {
            return new UsersDBAccess().auth(name, pass);
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
}
