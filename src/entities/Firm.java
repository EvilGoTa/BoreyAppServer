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
public class Firm implements Serializable{
    Integer id;
    String name;
    String country;
    String address;
    Integer license;
    String type;

    public Firm(Integer id, String name, String country, String address, Integer license, String type) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.address = address;
        this.license = license;
        this.type = type;
    }
    
    public Firm(){}

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

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLicense(Integer license) {
        this.license = license;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getAddress() {
        return address;
    }

    public Integer getLicense() {
        return license;
    }

    public String getType() {
        return type;
    }
    
    
}
