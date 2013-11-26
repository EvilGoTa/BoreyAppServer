
package appserver;

import DBAccess.AccountDBAccess;
import DBAccess.BankDBAccess;
import DBAccess.CurrencyDBAccess;
import DBAccess.ExRateDBAccess;
import DBAccess.FirmDBAccess;
import DBAccess.GoodsDBAccess;
import DBAccess.ReplacesDBAccess;
import DBAccess.UsersDBAccess;
import entities.Account;
import entities.Bank;
import entities.Currency;
import entities.ExchangeRate;
import entities.Firm;
import entities.Goods;
import entities.Replaces;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class Server extends UnicastRemoteObject implements ServerIntf{
    
    public Server() throws RemoteException{}

    @Override
    public int login (String login, String pass) throws RemoteException{
        UsersDBAccess nya = new UsersDBAccess();
        return nya.login(login, pass);
    }
    
    @Override
    public ArrayList<Goods> refreshGoods() throws RemoteException {
        GoodsDBAccess good = new GoodsDBAccess();
        return good.getGods();
    }

    @Override
    public int addGoods(Goods good) throws RemoteException {
        GoodsDBAccess nya = new GoodsDBAccess();
        try{
            return nya.addGoods(good);
        }
        catch(Exception e){
            System.out.println("AddGoods :"+e);
            return 0;
        }
    }

    @Override
    public int editGoods(Goods good) throws RemoteException {
        GoodsDBAccess nya = new GoodsDBAccess();
        try{
            return nya.editGoods(good);
        }
        catch(Exception e){
            System.out.println("EditGoods :"+e);
            return 0;
        }
    }

    @Override
    public int delGoods(Goods good) throws RemoteException {
        GoodsDBAccess nya = new GoodsDBAccess();
        try{
            return nya.delGoods(good);
        }
        catch(Exception e){
            System.out.println("DeleteGoods :"+e);
            return 0;
        }
    }

    @Override
    public ArrayList<Currency> refreshCurrency() throws RemoteException {
        CurrencyDBAccess curr = new CurrencyDBAccess();
        return curr.getCurrency();
    }

    @Override
    public int addCurrency(Currency curr) throws RemoteException {
        CurrencyDBAccess nya = new CurrencyDBAccess();
        try{
            return nya.addCurrency(curr);
        }
        catch(Exception e){
            System.out.println("AddCurrency :"+e);
            return 0;
        }
    }

    @Override
    public int editCurrency(Currency curr) throws RemoteException {
        CurrencyDBAccess nya = new CurrencyDBAccess();
        try{
            return nya.editCurrency(curr);
        }
        catch(Exception e){
            System.out.println("EditCurrency :"+e);
            return 0;
        }
    }

    @Override
    public int delCurrency(Currency curr) throws RemoteException {
        CurrencyDBAccess nya = new CurrencyDBAccess();
        try{
            return nya.delCurrency(curr);
        }
        catch(Exception e){
            System.out.println("DelCurrency :"+e);
            return 0;
        }
    }

    @Override
    public ArrayList<ExchangeRate> exRateRefresh() throws RemoteException{
        ExRateDBAccess exRate = new ExRateDBAccess();
        return exRate.getExRate();
    }

    @Override
    public int addExRate(ExchangeRate exRate) throws RemoteException {
        ExRateDBAccess exRateAcc = new ExRateDBAccess();
        return exRateAcc.addExRate(exRate);
    }

    @Override
    public int delExRate(ExchangeRate exRate) throws RemoteException {
        ExRateDBAccess exRateAcc = new ExRateDBAccess();
        return exRateAcc.delExRate(exRate);
    }

    @Override
    public ArrayList<Bank> bankRefresh() throws RemoteException {
        BankDBAccess nya = new BankDBAccess();
        return nya.getBank();
    }

    @Override
    public int addBank(Bank bank) throws RemoteException {
        BankDBAccess nya = new BankDBAccess();
        return nya.addBank(bank);
    }

    @Override
    public int editBank(Bank bank) throws RemoteException {
        BankDBAccess nya = new BankDBAccess();
        return nya.editBank(bank);
    }

    @Override
    public int delBank(Bank bank) throws RemoteException {
        BankDBAccess nya = new BankDBAccess();
        return nya.delBank(bank);
    }

    @Override
    public ArrayList<Firm> firmRefresh() throws RemoteException {
        FirmDBAccess nya = new FirmDBAccess();
        return nya.getFirm();
    }

    @Override
    public int addFirm(Firm firm) throws RemoteException {
        FirmDBAccess nya = new FirmDBAccess();
        return nya.addFirm(firm);
    }

    @Override
    public int editFirm(Firm firm) throws RemoteException {
        FirmDBAccess nya = new FirmDBAccess();
        return nya.editFirm(firm);
    }

    @Override
    public int delFirm(Firm firm) throws RemoteException {
        FirmDBAccess nya = new FirmDBAccess();
        return nya.delFirm(firm);
    }

    @Override
    public ArrayList<Account> accRefresh() throws RemoteException {
        AccountDBAccess nya = new AccountDBAccess();
        return nya.getAccounts();
    }

    @Override
    public int addAccount(Account acc) throws RemoteException {
        AccountDBAccess nya = new AccountDBAccess();
        return nya.addAccount(acc);
    }

    @Override
    public int editAccount(Account acc) throws RemoteException {
        AccountDBAccess nya = new AccountDBAccess();
        return nya.editAccount(acc);
    }

    @Override
    public int delAccount(Account acc) throws RemoteException {
        AccountDBAccess nya = new AccountDBAccess();
        return nya.deleteAccount(acc);
    }

    @Override
    public ArrayList<Replaces> replacesRefresh() throws RemoteException {
        ReplacesDBAccess nya = new ReplacesDBAccess();
        return nya.getReplaces();
    }

    @Override
    public int addReplaces(Replaces repl) throws RemoteException {
        ReplacesDBAccess nya = new ReplacesDBAccess();
        return nya.addReplaces(repl);
    }

    @Override
    public int delReplaces(Replaces repl) throws RemoteException {
        ReplacesDBAccess nya = new ReplacesDBAccess();
        return nya.delReplaces(repl);
    }
}
