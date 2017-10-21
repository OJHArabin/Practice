/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpn.demo.jta.slsb;

import com.cpn.demo.jta.entity.Goods;
import com.cpn.demo.jta.entity.Stock;
import com.sun.xml.ws.tx.at.tube.TransactionalAttribute;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transaction;

/**
 *
 * @author user
 */
@Stateless
public class GoodsFacade extends AbstractFacade<Goods> {
    
      @Resource
       EJBContext cont;
    @EJB
    private StockFacade stockFacade;
    @PersistenceContext(unitName = "JTADemoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GoodsFacade() {
        super(Goods.class);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String storeGoodsStock(Goods goods,int goodsQuantity)
    {
          
        
        try
        {
           create(goods); //call to method withis same class no transactional attribute active
           Stock stock=new Stock(goods.getGoodsID(),goodsQuantity);
            stockFacade.storeStock(stock);  //call to method outside same class transactional attribute active
            return "Added Successfully";
        }
        catch(Exception e)
        {
            
            
            cont.setRollbackOnly();
            return e.getMessage();
        }
    }
    
}
