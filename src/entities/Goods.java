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
public class Goods implements Serializable{
    Integer id;
    String name;
    Integer class_num;
    String tara;
    String firm_name;
    Integer count;
    Integer price;

    public Goods(Integer id, String name, Integer class_num, String tara, String firm_name, Integer count, Integer price) {
        this.id = id;
        this.name = name;
        this.class_num = class_num;
        this.tara = tara;
        this.firm_name = firm_name;
        this.count = count;
        this.price = price;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClass_num(Integer class_num) {
        this.class_num = class_num;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public void setFirm_name(String firm_name) {
        this.firm_name = firm_name;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getClass_num() {
        return class_num;
    }

    public String getTara() {
        return tara;
    }

    public String getFirm_name() {
        return firm_name;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getPrice() {
        return price;
    }
    
    
}
