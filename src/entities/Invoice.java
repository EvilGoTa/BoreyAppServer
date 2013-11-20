/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class Invoice implements Serializable{
    Integer id;
    String date;
    Integer firm_id;
    String firmName;

    public Invoice(Integer id, String date, Integer firm_id) {
        this.id = id;
        this.date = date;
        this.firm_id = firm_id;
    }

    public Invoice(Integer id, String date, Integer firm_id, String firmName) {
        this.id = id;
        this.date = date;
        this.firm_id = firm_id;
        this.firmName = firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFirm_id(Integer firm_id) {
        this.firm_id = firm_id;
    }

    public Integer getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public Integer getFirm_id() {
        return firm_id;
    }

    public String getFirmName() {
        return firmName;
    }
    
    
}
