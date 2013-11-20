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
public class Bank implements Serializable{
    Integer id;
    String name;
    String address;
    String location;
    Integer license_num;

    public Bank(Integer id, String name, String address, String location, Integer license_num) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.location = location;
        this.license_num = license_num;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLicense_num(Integer license_num) {
        this.license_num = license_num;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getLocation() {
        return location;
    }

    public Integer getLicense_num() {
        return license_num;
    }
    
    
}
