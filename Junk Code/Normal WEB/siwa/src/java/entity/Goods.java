/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.ejb.Singleton;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Rabin pc
 */
@Singleton
@Entity
@Table(name = "goods")
@NamedQueries(
        {
            @NamedQuery(name="Goods.findAll",query="select g from Goods g"),
            @NamedQuery(name="Goods.findByPrice",query="select g from Goods g where g.goodsPrice>:goodsPrice")
        })
public class Goods implements Serializable {

    @Id
    @Column(name="goods_id")
    private Integer goodsId;
    @Column(name = "goods_name")
    private String goodsName;
    @Column(name="goods_price") 
    private Float goodsPrice;

    public Goods(Integer goodsId, String goodsName, Float goodsPrice) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
    }

    public Goods() {
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "Goods{" + "goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice + '}';
    }

    public String getGoodsName() {
        return goodsName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.goodsId);
        hash = 59 * hash + Objects.hashCode(this.goodsName);
        hash = 59 * hash + Objects.hashCode(this.goodsPrice);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Goods other = (Goods) obj;
        if (!Objects.equals(this.goodsId, other.goodsId)) {
            return false;
        }
        if (!Objects.equals(this.goodsName, other.goodsName)) {
            return false;
        }
        if (!Objects.equals(this.goodsPrice, other.goodsPrice)) {
            return false;
        }
        return true;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
    
   
}
