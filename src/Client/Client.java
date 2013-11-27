package Client;

import appserver.ServerIntf;
import client_stuff.BookKeeperForm;
import client_stuff.GoodsManagerForm;
import client_stuff.LoginForm;
import client_stuff.ManagerForm;
import entities.Account;
import entities.Bank;
import entities.Currency;
import entities.ExchangeRate;
import entities.Firm;
import entities.Goods;
import entities.Replaces;
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
    ManagerForm manager = null;
    
    public Client() throws RemoteException{
        log = new LoginForm(this);
    }
    
    public int tryConnect(String IP, String login, String pass) throws NotBoundException, MalformedURLException, RemoteException{
        String serverIP = "rmi://"+IP+"/RMIServer";
        try{
            server = (ServerIntf) Naming.lookup(serverIP);
        }
        catch(Exception e){
            System.out.println("Error tryConnect_1: "+e);
            return -1;
        }
        int role = server.login(login, pass);
        if (role == 0){
            return 0;
        }
        switch(role){
            case 1:{
                goodsManage = new GoodsManagerForm(this);
                goodsManage.setVisible(true);
                break;
            }
            case 2:{
                bookKeeper = new BookKeeperForm(this);
                bookKeeper.setVisible(true);
                break;
            }
            case 3:{
                
                break;
            }
            case 4:{
                
                break;
            }
        }
        log.setVisible(false);
        log.dispose();
        return 1;
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
    
    public ArrayList<Firm> firmRefresh() throws RemoteException{
        return server.firmRefresh();
    }
    
    public int addFirm(Firm firm) throws RemoteException{
        return server.addFirm(firm);
    }
    
    public int editFirm(Firm firm) throws RemoteException{
        return server.editFirm(firm);
    }
    
    public int delFirm(Firm firm) throws RemoteException{
        return server.delFirm(firm);
    }
    
    public ArrayList<Account> accRefresh() throws RemoteException{
        return server.accRefresh();
    }
    
    public int addAccount(Account acc) throws RemoteException{
        return server.addAccount(acc);
    }
    
    public int editAccount(Account acc) throws RemoteException{
        return server.editAccount(acc);
    }
    
    public int delAccount(Account acc) throws RemoteException{
        return server.delAccount(acc);
    }
    
    public ArrayList<Replaces> replacesRefresh() throws RemoteException{
        return server.replacesRefresh();
    }
    
    public int addReplaces(Replaces repl) throws RemoteException{
        return server.addReplaces(repl);
    }
    
    public int delReplaces(Replaces repl) throws RemoteException{
        return server.delReplaces(repl);
    }
    
}
