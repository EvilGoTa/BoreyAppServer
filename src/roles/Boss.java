/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roles;

import DBAccess.FirmDBAccess;
import DBAccess.InvoiceDBAccess;
import DBAccess.PODBAccess;
import entities.Firm;
import entities.InvoiceReport;
import entities.PaymentOrder;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import remote.RemoteBoss;

/**
 *
 * @author Asus
 */
public class Boss extends UnicastRemoteObject implements RemoteBoss{

    public Boss() throws RemoteException {
        super();
    }

    public Boss(int port) throws RemoteException {
        super(port);
    }

    public Boss(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    @Override
    public ArrayList<Firm> getFirmList() throws RemoteException {
        return new FirmDBAccess().getFirm();
    }

    @Override
    public ArrayList<PaymentOrder> getPOList() throws RemoteException {
        return new PODBAccess().getPO();
    }

    @Override
    public ArrayList<InvoiceReport> getReport() throws RemoteException, SQLException {
        return new InvoiceDBAccess().getReport();
    }
    
    
}
