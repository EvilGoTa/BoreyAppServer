/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Asus
 */
public class PaymentOrder {
    Integer department_id;
    Integer account_id;
    String date;
    Integer total_amount;
    Integer invoice_id;

    public PaymentOrder(Integer department_id, Integer account_id, String date, Integer total_amount, Integer invoice_id) {
        this.department_id = department_id;
        this.account_id = account_id;
        this.date = date;
        this.total_amount = total_amount;
        this.invoice_id = invoice_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTotal_amount(Integer total_amount) {
        this.total_amount = total_amount;
    }

    public void setInvoice_id(Integer invoice_id) {
        this.invoice_id = invoice_id;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public String getDate() {
        return date;
    }

    public Integer getTotal_amount() {
        return total_amount;
    }

    public Integer getInvoice_id() {
        return invoice_id;
    }
    
    
}
