/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Asus
 */
public interface RemoteLogin extends Remote{
    Integer tryLogin(String name, String pass) throws RemoteException;
}
