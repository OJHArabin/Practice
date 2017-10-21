/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpn.demo.jta.helper;

/**
 *
 * @author user
 */
public class MyException extends Exception
{
    public MyException()
    {
         super("Value must be more than 15");
    }

    

    public MyException(String string) {
       super(string);
    }

    public MyException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public MyException(Throwable thrwbl) {
        super(thrwbl);
    }
}
