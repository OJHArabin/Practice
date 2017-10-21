/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpn.demo.jta.slsb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author user
 */
@Stateless
public class FirtEJB 
{
    @EJB
    SecondEJB secondEJB;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int first(int a,int b,int c)
    {
        return secondEJB.second(a+b,c);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
