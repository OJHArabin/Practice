/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpn.demo.jta.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author user
 */
@Entity
@Table(name = "sales")
@NamedQueries({
    @NamedQuery(name = "Sales.findAll", query = "SELECT s FROM Sales s"),
    @NamedQuery(name = "Sales.findBySalesID", query = "SELECT s FROM Sales s WHERE s.salesID = :salesID"),
    @NamedQuery(name = "Sales.findBySalesDate", query = "SELECT s FROM Sales s WHERE s.salesDate = :salesDate"),
    @NamedQuery(name = "Sales.findBySalesQuantity", query = "SELECT s FROM Sales s WHERE s.salesQuantity = :salesQuantity")})
public class Sales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sales_ID")
    private Integer salesID;
    @Column(name = "sales_Date")
    @Temporal(TemporalType.DATE)
    private Date salesDate;
    @Column(name = "sales_Quantity")
    private Integer salesQuantity;
    @JoinColumn(name = "goods_ID", referencedColumnName = "goods_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Goods goodsID;

    public Sales() {
    }

    public Sales(Integer salesID) {
        this.salesID = salesID;
    }

    public Integer getSalesID() {
        return salesID;
    }

    public void setSalesID(Integer salesID) {
        this.salesID = salesID;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public Integer getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(Integer salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public Goods getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(Goods goodsID) {
        this.goodsID = goodsID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salesID != null ? salesID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sales)) {
            return false;
        }
        Sales other = (Sales) object;
        if ((this.salesID == null && other.salesID != null) || (this.salesID != null && !this.salesID.equals(other.salesID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cpn.demo.jta.entity.Sales[ salesID=" + salesID + " ]";
    }
    
}
