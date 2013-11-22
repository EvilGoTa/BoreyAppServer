
package appserver;

import entities.Bank;
import entities.Currency;
import entities.ExchangeRate;
import entities.Goods;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServerIntf extends Remote{
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
}
