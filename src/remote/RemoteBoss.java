/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;
import entities.Firm;
import entities.InvoiceReport;
import entities.PaymentOrder;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.rmi.Remote;
/**
 *
 * @author Asus
 */
public interface RemoteBoss extends Remote{
    ArrayList<Firm> getFirmList() throws RemoteException;
    ArrayList<PaymentOrder> getPOList() throws RemoteException;
    ArrayList<InvoiceReport> getReport() throws RemoteException, SQLException;
}
