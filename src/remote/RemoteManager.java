/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import entities.Goods;
import entities.GoodsInInv;
import entities.Invoice;
import entities.Firm;
import java.util.ArrayList;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Asus
 */
public interface RemoteManager extends Remote{
    ArrayList<Goods> getGoodsList() throws RemoteException;
    //void addGoods(Goods goods) throws RemoteException;
    //void editGoods(Goods goods) throws RemoteException;
    //void deleteGoods(Goods goods) throws RemoteException;
    ArrayList<GoodsInInv> getGINList() throws RemoteException;
    ArrayList<GoodsInInv> getGINList(int inv_id) throws RemoteException;
    void addGIN(GoodsInInv gin) throws RemoteException;
    void editGIN(GoodsInInv gin) throws RemoteException;
    void deleteGIN(GoodsInInv gin) throws RemoteException;
    ArrayList<Invoice> getInvoiceList() throws RemoteException;
    void addInvoice(Invoice inv) throws RemoteException;
    void editInvoice(Invoice inv) throws RemoteException;
    void deleteInvoice(Invoice inv) throws RemoteException;
    ArrayList<Firm> getFirmList() throws RemoteException;
}
