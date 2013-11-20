/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package roles;

import DBAccess.GoodsDBAccess;
import DBAccess.GoodsInInvDBAccess;
import DBAccess.FirmDBAccess;
import DBAccess.InvoiceDBAccess;
import entities.Firm;
import entities.Goods;
import entities.GoodsInInv;
import entities.Invoice;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import remote.RemoteManager;

/**
 *
 * @author Роман
 */
public class Manager extends UnicastRemoteObject implements RemoteManager{

    public Manager() throws RemoteException {
        super();
    }
    
    @Override
    public ArrayList<Goods> getGoodsList() throws RemoteException {
        return new GoodsDBAccess().getGods();
    }

    @Override
    public ArrayList<GoodsInInv> getGINList() throws RemoteException {
        return new GoodsInInvDBAccess().getGIN();
    }

    @Override
    public void addGIN(GoodsInInv gin) throws RemoteException {
        new GoodsInInvDBAccess().addGIN(gin);
    }

    @Override
    public void editGIN(GoodsInInv gin) throws RemoteException {
        new GoodsInInvDBAccess().editGIN(gin);
    }

    @Override
    public void deleteGIN(GoodsInInv gin) throws RemoteException {
        new GoodsInInvDBAccess().delGIN(gin);
    }

    @Override
    public ArrayList<Invoice> getInvoiceList() throws RemoteException {
        return new InvoiceDBAccess().getInvoice();
    }

    @Override
    public void addInvoice(Invoice inv) throws RemoteException {
        new InvoiceDBAccess().addInvoice(inv);
    }

    @Override
    public void editInvoice(Invoice inv) throws RemoteException {
        new InvoiceDBAccess().editInvoice(inv);
    }

    @Override
    public void deleteInvoice(Invoice inv) throws RemoteException {
        new InvoiceDBAccess().delInvoice(inv);
    }

    @Override
    public ArrayList<Firm> getFirmList() throws RemoteException {
        return new FirmDBAccess().getFirm();
    }

    @Override
    public ArrayList<GoodsInInv> getGINList(int inv_id) throws RemoteException {
        return new GoodsInInvDBAccess().getGIN(inv_id);
    }
    
}
