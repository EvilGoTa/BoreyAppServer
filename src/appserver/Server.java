
package appserver;

import DBAccess.BankDBAccess;
import DBAccess.CurrencyDBAccess;
import DBAccess.ExRateDBAccess;
import DBAccess.GoodsDBAccess;
import entities.Bank;
import entities.Currency;
import entities.ExchangeRate;
import entities.Goods;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class Server extends UnicastRemoteObject implements ServerIntf{
    
    public Server() throws RemoteException{     
    }

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
    
    
}
