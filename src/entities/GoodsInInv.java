/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Asus
 */
public class GoodsInInv {
    Integer id;
    Integer inv_id;
    Integer goods_count;
    Integer valid;

    public GoodsInInv(Integer id, Integer inv_id, Integer goods_count, Integer valid) {
        this.id = id;
        this.inv_id = inv_id;
        this.goods_count = goods_count;
        this.valid = valid;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setInv_id(Integer inv_id) {
        this.inv_id = inv_id;
    }

    public void setGoods_count(Integer goods_count) {
        this.goods_count = goods_count;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Integer getId() {
        return id;
    }

    public Integer getInv_id() {
        return inv_id;
    }

    public Integer getGoods_count() {
        return goods_count;
    }

    public Integer getValid() {
        return valid;
    }
    
    
}
