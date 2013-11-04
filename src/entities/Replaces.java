/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Asus
 */
public class Replaces {
    Integer good_id;
    Integer replace_good_id;

    public Replaces(Integer good_id, Integer replace_good_id) {
        this.good_id = good_id;
        this.replace_good_id = replace_good_id;
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
    
    
}
