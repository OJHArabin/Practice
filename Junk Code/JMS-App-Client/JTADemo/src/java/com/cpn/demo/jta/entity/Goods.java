/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpn.demo.jta.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Entity
@Table(name = "goods")
@NamedQueries({
    @NamedQuery(name = "Goods.findAll", query = "SELECT g FROM Goods g"),
    @NamedQuery(name = "Goods.findByGoodsID", query = "SELECT g FROM Goods g WHERE g.goodsID = :goodsID"),
    @NamedQuery(name = "Goods.findByGoodsName", query = "SELECT g FROM Goods g WHERE g.goodsName = :goodsName"),
    @NamedQuery(name = "Goods.findByGoodsPrice", query = "SELECT g FROM Goods g WHERE g.goodsPrice = :goodsPrice")})
public class Goods implements Serializable {
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "goods", fetch = FetchType.EAGER)
    private Stock stock;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "goods_ID")
    private Integer goodsID;
    @Size(max = 40)
    @Column(name = "goods_Name")
    private String goodsName;

    public Goods(Integer goodsID, String goodsName, Integer goodsPrice) {
        this.goodsID = goodsID;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
    }
    @Column(name = "goods_Price")
    private Integer goodsPrice;

    public Goods(Integer goodsID, String goodsName, Integer goodsPrice, List<Sales> salesList) {
        this.goodsID = goodsID;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.salesList = salesList;
    }
    @OneToMany(mappedBy = "goodsID", fetch = FetchType.EAGER)
    private List<Sales> salesList;

    public Goods() {
    }

    public Goods(Integer goodsID) {
        this.goodsID = goodsID;
    }

    public Integer getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(Integer goodsID) {
        this.goodsID = goodsID;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public List<Sales> getSalesList() {
        return salesList;
    }

    public void setSalesList(List<Sales> salesList) {
        this.salesList = salesList;
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
        if (!(object instanceof Goods)) {
            return false;
        }
        Goods other = (Goods) object;
        if ((this.goodsID == null && other.goodsID != null) || (this.goodsID != null && !this.goodsID.equals(other.goodsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cpn.demo.jta.entity.Goods[ goodsID=" + goodsID + " ]";
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
    
}
