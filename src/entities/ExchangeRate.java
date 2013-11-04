/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Asus
 */
public class ExchangeRate {
    Integer id;
    Integer currency_id_1;
    Integer currency_id_2;
    String date;
    Float ratio;

    public ExchangeRate(Integer id, Integer currency_id_1, Integer currency_id_2, String date, Float ratio) {
        this.id = id;
        this.currency_id_1 = currency_id_1;
        this.currency_id_2 = currency_id_2;
        this.date = date;
        this.ratio = ratio;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCurrency_id_1(Integer currency_id_1) {
        this.currency_id_1 = currency_id_1;
    }

    public void setCurrency_id_2(Integer currency_id_2) {
        this.currency_id_2 = currency_id_2;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRatio(Float ratio) {
        this.ratio = ratio;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCurrency_id_1() {
        return currency_id_1;
    }

    public Integer getCurrency_id_2() {
        return currency_id_2;
    }

    public String getDate() {
        return date;
    }

    public Float getRatio() {
        return ratio;
    }
    
    
}
