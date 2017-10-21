/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpn.demo.jta.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author user
 */
@Entity
@Table(name = "stock")
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s"),
    @NamedQuery(name = "Stock.findByGoodsID", query = "SELECT s FROM Stock s WHERE s.goodsID = :goodsID"),
    @NamedQuery(name = "Stock.findByGoodsCount", query = "SELECT s FROM Stock s WHERE s.goodsCount = :goodsCount")})
public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "goods_ID")
    private Integer goodsID;

    public Stock(Integer goodsID, Integer goodsCount) {
        this.goodsID = goodsID;
        this.goodsCount = goodsCount;
    }
    @Column(name = "goods_Count")
    private Integer goodsCount;

    public Stock(Integer goodsID, Integer goodsCount, Goods goods) {
        this.goodsID = goodsID;
        this.goodsCount = goodsCount;
        this.goods = goods;
    }
    @JoinColumn(name = "goods_ID", referencedColumnName = "goods_ID", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Goods goods;

    public Stock() {
    }

    public Stock(Integer goodsID) {
        this.goodsID = goodsID;
    }

    public Integer getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(Integer goodsID) {
        this.goodsID = goodsID;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (goodsID != null ? goodsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.goodsID == null && other.goodsID != null) || (this.goodsID != null && !this.goodsID.equals(other.goodsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cpn.demo.jta.entity.Stock[ goodsID=" + goodsID + " ]";
    }
    
}
