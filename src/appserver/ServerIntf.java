
package appserver;

import entities.Account;
import entities.Bank;
import entities.Currency;
import entities.ExchangeRate;
import entities.Firm;
import entities.Goods;
import entities.Invoice;
import entities.PaymentOrder;
import entities.Replaces;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ServerIntf extends Remote{
    public int login(String login, String pass) throws RemoteException, SQLException;
    
    public ArrayList<Goods> refreshGoods() throws RemoteException, SQLException;
    public void addGoods(Goods good) throws RemoteException, SQLException;
    public void editGoods(Goods good) throws RemoteException, SQLException;
    public void delGoods(Goods good) throws RemoteException, SQLException;
    
    public ArrayList<Currency> refreshCurrency() throws RemoteException, SQLException;
    public void addCurrency(Currency curr) throws RemoteException, SQLException;
    public void editCurrency(Currency curr) throws RemoteException, SQLException;
    public void delCurrency(Currency curr) throws RemoteException, SQLException;
    
    public ArrayList<ExchangeRate> exRateRefresh() throws RemoteException, SQLException;
    public void addExRate(ExchangeRate exRate) throws RemoteException, SQLException;
    public void delExRate(ExchangeRate exRate) throws RemoteException, SQLException;
    
    public ArrayList<Bank> bankRefresh() throws RemoteException, SQLException;
    public void addBank(Bank bank) throws RemoteException, SQLException;
    public void editBank(Bank bank) throws RemoteException, SQLException;
    public void delBank(Bank bank) throws RemoteException, SQLException;
    
    public ArrayList<Firm> firmRefresh() throws RemoteException, SQLException;
    public void addFirm(Firm firm) throws RemoteException, SQLException;
    public void editFirm(Firm firm) throws RemoteException, SQLException;
    public void delFirm(Firm firm) throws RemoteException, SQLException;
    
    public ArrayList<Account> accRefresh() throws RemoteException, SQLException;
    public void addAccount(Account acc) throws RemoteException, SQLException;
    public void editAccount(Account acc) throws RemoteException, SQLException;
    public void delAccount(Account acc) throws RemoteException, SQLException;
    
    public ArrayList<Replaces> replacesRefresh() throws RemoteException, SQLException;
    public void addReplaces(Replaces repl) throws RemoteException, SQLException;
    public void delReplaces(Replaces repl) throws RemoteException, SQLException;
    public ArrayList<Replaces> getReplacesOf(Goods good) throws RemoteException, SQLException;

    public ArrayList<PaymentOrder> peyOrdRefresh() throws RemoteException, SQLException;
    public void addPayOrd(PaymentOrder payOrd) throws RemoteException, SQLException;
    public void delPayOrd(PaymentOrder payOrd) throws RemoteException, SQLException;
    public ArrayList<Invoice> getInvWOPO() throws RemoteException, SQLException;
}
