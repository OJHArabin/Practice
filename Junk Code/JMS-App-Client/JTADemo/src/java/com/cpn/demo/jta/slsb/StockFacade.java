/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpn.demo.jta.slsb;

import com.cpn.demo.jta.entity.Stock;
import com.cpn.demo.jta.entity.Test;
import com.cpn.demo.jta.helper.MyException;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author user
 */
@Stateless
public class StockFacade extends AbstractFacade<Stock> {
    
    @PersistenceContext(unitName = "JTADemoPU")
    private EntityManager em;
    
    @EJB
    TestFacade testFacade;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StockFacade() {
        super(Stock.class);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void storeStock(Stock stock) throws MyException
    {
       //   create(stock);
          
       // The problem with transaction attribute Requires new is that it suspends earlier transaction and so goods data is not persisted 
          // and stock without goods gives an error in database
      /*    if(stock.getGoodsCount()<15)
        throw new RuntimeException("Some Exception");
        create(stock);
                */
      
          //If we insert data in an unrelated table then the previous problem is not seen as the suspension of previous transaction has no effect in this 
          // data
           if(stock.getGoodsCount()<15)
        throw new MyException();
           
           Test t=new Test("adsf",3,"asdf");
           testFacade.create(t);
            /*      */
    }
    
}
