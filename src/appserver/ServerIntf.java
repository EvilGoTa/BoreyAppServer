
package appserver;

import entities.Account;
import entities.Bank;
import entities.Currency;
import entities.ExchangeRate;
import entities.Firm;
import entities.Goods;
import entities.Replaces;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServerIntf extends Remote{
    public int login(String login, String pass) throws RemoteException;
    
    public ArrayList<Goods> refreshGoods() throws RemoteException;
    public int addGoods(Goods good) throws RemoteException;
    public int editGoods(Goods good) throws RemoteException;
    public int delGoods(Goods good) throws RemoteException;
    
    public ArrayList<Currency> refreshCurrency() throws RemoteException;
    public int addCurrency(Currency curr) throws RemoteException;
    public int editCurrency(Currency curr) throws RemoteException;
    public int delCurrency(Currency curr) throws RemoteException;
    
    public ArrayList<ExchangeRate> exRateRefresh() throws RemoteException;
    public int addExRate(ExchangeRate exRate) throws RemoteException;
    public int delExRate(ExchangeRate exRate) throws RemoteException;
    
    public ArrayList<Bank> bankRefresh() throws RemoteException;
    public int addBank(Bank bank) throws RemoteException;
    public int editBank(Bank bank) throws RemoteException;
    public int delBank(Bank bank) throws RemoteException;
    
    public ArrayList<Firm> firmRefresh() throws RemoteException;
    public int addFirm(Firm firm) throws RemoteException;
    public int editFirm(Firm firm) throws RemoteException;
    public int delFirm(Firm firm) throws RemoteException;
    
    public ArrayList<Account> accRefresh() throws RemoteException;
    public int addAccount(Account acc) throws RemoteException;
    public int editAccount(Account acc) throws RemoteException;
    public int delAccount(Account acc) throws RemoteException;
    
    public ArrayList<Replaces> replacesRefresh() throws RemoteException;
    public int addReplaces(Replaces repl) throws RemoteException;
    public int delReplaces(Replaces repl) throws RemoteException;
}
