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
public class Replaces implements Serializable{
    Integer good_id;
    Integer replace_good_id;
    String name1, name2;
    
    public Replaces(){}
    
    public Replaces(Integer good_id, Integer replace_good_id) {
        this.good_id = good_id;
        this.replace_good_id = replace_good_id;
    }

    public Replaces(Integer good_id, Integer replace_good_id, String name1, String name2) {
        this.good_id = good_id;
        this.replace_good_id = replace_good_id;
        this.name1 = name1;
        this.name2 = name2;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }
    
    public void setGood_id(Integer good_id) {
        this.good_id = good_id;
    }

    public void setReplace_good_id(Integer replace_good_id) {
        this.replace_good_id = replace_good_id;
    }

    public Integer getGood_id() {
        return good_id;
    }

    public Integer getReplace_good_id() {
        return replace_good_id;
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }
    
    
}
