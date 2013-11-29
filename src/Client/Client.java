package Client;

import appserver.ServerIntf;
import client_stuff.BookKeeperForm;
import client_stuff.GoodsManagerForm;
import client_stuff.LoginForm;
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
import java.sql.SQLException;
import java.util.ArrayList;

public class Client extends UnicastRemoteObject{
    LoginForm log = null;
    GoodsManagerForm goodsManage = null;
    BookKeeperForm bookKeeper = null;
    ServerIntf server;
    
    public Client() throws RemoteException{
        log = new LoginForm(this);
    }
    
    public int tryConnect(String IP, String login, String pass) throws NotBoundException, MalformedURLException, RemoteException, SQLException{
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
    
    public ArrayList<Currency> refreshCurrency() throws RemoteException, SQLException{
        return server.refreshCurrency();
    }
    
    public ArrayList<Goods> refreshGoods() throws RemoteException, SQLException{
        return server.refreshGoods();
    }
    
    public void addGoods(Goods good) throws RemoteException, SQLException{
        server.addGoods(good);
    }
    
    public void editGoods(Goods good) throws RemoteException, SQLException{
        server.editGoods(good);
    }
    
    public void delGoods(Goods good) throws RemoteException, SQLException{
        server.delGoods(good);
    }
    
    public void addCurrency(Currency curr) throws RemoteException, SQLException{
        server.addCurrency(curr);
    }
    
    public void editCurrency(Currency curr) throws RemoteException, SQLException{
        server.editCurrency(curr);
    }
    
    public void delCurrency(Currency curr) throws RemoteException, SQLException{
        server.delCurrency(curr);
    }
    
    public ArrayList<ExchangeRate> exRateRefresh() throws RemoteException, SQLException{
        return server.exRateRefresh();
    }
    
    public void addExRate(ExchangeRate exRate) throws RemoteException, SQLException{
        server.addExRate(exRate);
    }
    
    public void delExRate(ExchangeRate exRate) throws RemoteException, SQLException{
        server.delExRate(exRate);
    }
    
    public ArrayList<Bank> bankRefresh() throws RemoteException, SQLException{
        return server.bankRefresh();
    }
    
    public void addBank(Bank bank) throws RemoteException, SQLException{
        server.addBank(bank);
    }
    
    public void delBank(Bank bank) throws RemoteException, SQLException{
        server.delBank(bank);
    }
    
    public void editBank(Bank bank) throws RemoteException, SQLException{
        server.editBank(bank);
    }
    
    public ArrayList<Firm> firmRefresh() throws RemoteException, SQLException{
        return server.firmRefresh();
    }
    
    public void addFirm(Firm firm) throws RemoteException, SQLException{
        server.addFirm(firm);
    }
    
    public void editFirm(Firm firm) throws RemoteException, SQLException{
        server.editFirm(firm);
    }
    
    public void delFirm(Firm firm) throws RemoteException, SQLException{
        server.delFirm(firm);
    }
    
    public ArrayList<Account> accRefresh() throws RemoteException, SQLException{
        return server.accRefresh();
    }
    
    public void addAccount(Account acc) throws RemoteException, SQLException{
        server.addAccount(acc);
    }
    
    public void editAccount(Account acc) throws RemoteException, SQLException{
        server.editAccount(acc);
    }
    
    public void delAccount(Account acc) throws RemoteException, SQLException{
        server.delAccount(acc);
    }
    
    public ArrayList<Replaces> replacesRefresh() throws RemoteException, SQLException{
        return server.replacesRefresh();
    }
    
    public void addReplaces(Replaces repl) throws RemoteException, SQLException{
        server.addReplaces(repl);
    }
    
    public void delReplaces(Replaces repl) throws RemoteException, SQLException{
        server.delReplaces(repl);
    }
    
    public ArrayList<Replaces> getReplaceOf(Goods good) throws RemoteException, SQLException{
        return server.getReplacesOf(good);
    }
}
