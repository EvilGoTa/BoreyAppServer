/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Asus
 */
public class Invoice {
    Integer id;
    String date;
    Integer firm_id;

    public Invoice(Integer id, String date, Integer firm_id) {
        this.id = id;
        this.date = date;
        this.firm_id = firm_id;
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
    
    
}
