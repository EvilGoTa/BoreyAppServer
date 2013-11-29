
package appserver;

import DBAccess.AccountDBAccess;
import DBAccess.BankDBAccess;
import DBAccess.CurrencyDBAccess;
import DBAccess.ExRateDBAccess;
import DBAccess.FirmDBAccess;
import DBAccess.GoodsDBAccess;
import DBAccess.InvoiceDBAccess;
import DBAccess.PODBAccess;
import DBAccess.ReplacesDBAccess;
import DBAccess.UsersDBAccess;
import entities.Account;
import entities.Bank;
import entities.Currency;
import entities.ExchangeRate;
import entities.Firm;
import entities.Goods;
import entities.Invoice;
import entities.PaymentOrder;
import entities.Replaces;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;


public class Server extends UnicastRemoteObject implements ServerIntf{
    
    public Server() throws RemoteException{}

    public int login (String login, String pass) throws RemoteException, SQLException{
        UsersDBAccess nya = new UsersDBAccess();
        return nya.login(login, pass);
    }
    
    public ArrayList<Goods> refreshGoods() throws RemoteException, SQLException {
        GoodsDBAccess good = new GoodsDBAccess();
        return good.getGods();
    }

    public void addGoods(Goods good) throws RemoteException, SQLException {
        GoodsDBAccess nya = new GoodsDBAccess();
        nya.addGoods(good);
    }

    public void editGoods(Goods good) throws RemoteException, SQLException {
        GoodsDBAccess nya = new GoodsDBAccess();
        nya.editGoods(good);
    }

    public void delGoods(Goods good) throws RemoteException, SQLException {
        GoodsDBAccess nya = new GoodsDBAccess();
        nya.delGoods(good);
    }

    public ArrayList<Currency> refreshCurrency() throws RemoteException, SQLException {
        CurrencyDBAccess curr = new CurrencyDBAccess();
        return curr.getCurrency();
    }

    public void addCurrency(Currency curr) throws RemoteException, SQLException {
        CurrencyDBAccess nya = new CurrencyDBAccess();
        nya.addCurrency(curr);
    }

    public void editCurrency(Currency curr) throws RemoteException, SQLException {
        CurrencyDBAccess nya = new CurrencyDBAccess();
        nya.editCurrency(curr);
    }

    public void delCurrency(Currency curr) throws RemoteException, SQLException {
        CurrencyDBAccess nya = new CurrencyDBAccess();
        nya.delCurrency(curr);
    }

    public ArrayList<ExchangeRate> exRateRefresh() throws RemoteException, SQLException{
        ExRateDBAccess exRate = new ExRateDBAccess();
        return exRate.getExRate();
    }

    public void addExRate(ExchangeRate exRate) throws RemoteException, SQLException {
        ExRateDBAccess exRateAcc = new ExRateDBAccess();
        exRateAcc.addExRate(exRate);
    }

    public void delExRate(ExchangeRate exRate) throws RemoteException, SQLException {
        ExRateDBAccess exRateAcc = new ExRateDBAccess();
        exRateAcc.delExRate(exRate);
    }

    public ArrayList<Bank> bankRefresh() throws RemoteException, SQLException {
        BankDBAccess nya = new BankDBAccess();
        return nya.getBank();
    }

    public void addBank(Bank bank) throws RemoteException, SQLException {
        BankDBAccess nya = new BankDBAccess();
        nya.addBank(bank);
    }

    public void editBank(Bank bank) throws RemoteException, SQLException {
        BankDBAccess nya = new BankDBAccess();
        nya.editBank(bank);
    }

    public void delBank(Bank bank) throws RemoteException, SQLException {
        BankDBAccess nya = new BankDBAccess();
        nya.delBank(bank);
    }

    public ArrayList<Firm> firmRefresh() throws RemoteException, SQLException {
        FirmDBAccess nya = new FirmDBAccess();
        return nya.getFirm();
    }

    public void addFirm(Firm firm) throws RemoteException, SQLException {
        FirmDBAccess nya = new FirmDBAccess();
        nya.addFirm(firm);
    }

    public void editFirm(Firm firm) throws RemoteException, SQLException {
        FirmDBAccess nya = new FirmDBAccess();
        nya.editFirm(firm);
    }

    public void delFirm(Firm firm) throws RemoteException, SQLException {
        FirmDBAccess nya = new FirmDBAccess();
        nya.delFirm(firm);
    }

    public ArrayList<Account> accRefresh() throws RemoteException, SQLException {
        AccountDBAccess nya = new AccountDBAccess();
        return nya.getAccounts();
    }

    public void addAccount(Account acc) throws RemoteException, SQLException {
        AccountDBAccess nya = new AccountDBAccess();
        nya.addAccount(acc);
    }

    public void editAccount(Account acc) throws RemoteException, SQLException {
        AccountDBAccess nya = new AccountDBAccess();
        nya.editAccount(acc);
    }

    public void delAccount(Account acc) throws RemoteException, SQLException {
        AccountDBAccess nya = new AccountDBAccess();
        nya.deleteAccount(acc);
    }

    public ArrayList<Replaces> replacesRefresh() throws RemoteException, SQLException {
        ReplacesDBAccess nya = new ReplacesDBAccess();
        return nya.getReplaces();
    }

    public void addReplaces(Replaces repl) throws RemoteException, SQLException {
        ReplacesDBAccess nya = new ReplacesDBAccess();
        nya.addReplaces(repl);
    }

    public void delReplaces(Replaces repl) throws RemoteException, SQLException {
        ReplacesDBAccess nya = new ReplacesDBAccess();
        nya.delReplaces(repl);
    }

    public ArrayList<Replaces> getReplacesOf(Goods good) throws RemoteException, SQLException {
        ReplacesDBAccess nya = new ReplacesDBAccess();
        return nya.getReplacesOf(good);
    }

    public ArrayList<PaymentOrder> peyOrdRefresh() throws RemoteException, SQLException {
        PODBAccess nya = new PODBAccess();
        return nya.getPO();
    }

    public void addPayOrd(PaymentOrder payOrd) throws RemoteException, SQLException {
        PODBAccess nya = new PODBAccess();
        nya.addPO(payOrd);
    }

    public void delPayOrd(PaymentOrder payOrd) throws RemoteException, SQLException {
        PODBAccess nya = new PODBAccess();
        nya.delPO(payOrd);
    }

    public ArrayList<Invoice> getInvWOPO() throws RemoteException, SQLException {
        InvoiceDBAccess nya = new InvoiceDBAccess();
        return nya.getInvoicesWitNoPO();
    }
}
