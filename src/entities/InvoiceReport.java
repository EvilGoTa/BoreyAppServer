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
public class InvoiceReport implements Serializable{
    Integer firm_id;
    String firm_name;
    Integer sum;

    public InvoiceReport(Integer firm_id, String firm_name, Integer sum) {
        this.firm_id = firm_id;
        this.firm_name = firm_name;
        this.sum = sum;
    }

    public void setFirm_id(Integer firm_id) {
        this.firm_id = firm_id;
    }

    public void setFirm_name(String firm_name) {
        this.firm_name = firm_name;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getFirm_id() {
        return firm_id;
    }

    public String getFirm_name() {
        return firm_name;
    }

    public Integer getSum() {
        return sum;
    }
    
    
}
