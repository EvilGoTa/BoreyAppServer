/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Asus
 */
public class Account {
    Integer id;
    Integer firm_id;
    Integer currency_id;
    Integer bank_id;
    String account_type;

    public Account(Integer id, Integer firm_id, Integer currency_id, Integer bank_id, String account_type) {
        this.id = id;
        this.firm_id = firm_id;
        this.currency_id = currency_id;
        this.bank_id = bank_id;
        this.account_type = account_type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirm_id(Integer firm_id) {
        this.firm_id = firm_id;
    }

    public void setCurrency_id(Integer currency_id) {
        this.currency_id = currency_id;
    }

    public void setBank_id(Integer bank_id) {
        this.bank_id = bank_id;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public Integer getId() {
        return id;
    }

    public Integer getFirm_id() {
        return firm_id;
    }

    public Integer getCurrency_id() {
        return currency_id;
    }

    public Integer getBank_id() {
        return bank_id;
    }

    public String getAccount_type() {
        return account_type;
    }
    
    
}
