package Client;

import appserver.ServerIntf;
import client_stuff.BookKeeperForm;
import client_stuff.GoodsManagerForm;
import client_stuff.LoginForm;
import entities.Bank;
import entities.Currency;
import entities.ExchangeRate;
import entities.Goods;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Client extends UnicastRemoteObject{
    LoginForm log = null;
    GoodsManagerForm goodsManage = null;
    BookKeeperForm bookKeeper = null;
    ServerIntf server;
    
    public Client() throws RemoteException{
        log = new LoginForm(this);
    }
    
    public void tryConnect(String IP, String login, char pass[]) throws NotBoundException, MalformedURLException, RemoteException{
        String serverIP = "rmi://"+IP+"/RMIServer";
        try{
            server = (ServerIntf) Naming.lookup(serverIP);
        }
        catch(Exception e){
            System.out.println("Error tryConnect_1: "+e);
        }
        log.setVisible(false);
        log.dispose();
        goodsManage = new GoodsManagerForm(this);
        goodsManage.setVisible(true);
        bookKeeper = new BookKeeperForm(this);
        bookKeeper.setVisible(true);
        
    }
    
    public ArrayList<Currency> refreshCurrency() throws RemoteException{
        return server.refreshCurrency();
    }
    
    public ArrayList<Goods> refreshGoods() throws RemoteException{
        return server.refreshGoods();
    }
    
    public int addGoods(Goods good) throws RemoteException{
        return server.addGoods(good);
    }
    
    public int editGoods(Goods good) throws RemoteException{
        return server.editGoods(good);
    }
    
    public int delGoods(Goods good) throws RemoteException{
        return server.delGoods(good);
    }
    
    public int addCurrency(Currency curr) throws RemoteException{
        return server.addCurrency(curr);
    }
    
    public int editCurrency(Currency curr) throws RemoteException{
        return server.editCurrency(curr);
    }
    
    public int delCurrency(Currency curr) throws RemoteException{
        return server.delCurrency(curr);
    }
    
    public ArrayList<ExchangeRate> exRateRefresh() throws RemoteException{
        return server.exRateRefresh();
    }
    
    public int addExRate(ExchangeRate exRate) throws RemoteException{
        return server.addExRate(exRate);
    }
    
    public int delExRate(ExchangeRate exRate) throws RemoteException{
        return server.delExRate(exRate);
    }
    
    public ArrayList<Bank> bankRefresh() throws RemoteException{
        return server.bankRefresh();
    }
    
    public int addBank(Bank bank) throws RemoteException{
        return server.addBank(bank);
    }
    
    public int delBank(Bank bank) throws RemoteException{
        return server.delBank(bank);
    }
    
    public int editBank(Bank bank) throws RemoteException{
        return server.editBank(bank);
    }
}
