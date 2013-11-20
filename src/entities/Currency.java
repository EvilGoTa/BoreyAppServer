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
public class Currency implements Serializable{
    Integer id;
    String name;
    String country;
    String desc;

    public Currency(Integer id, String name, String country, String desc) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.desc = desc;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getDesc() {
        return desc;
    }
    
    
}
