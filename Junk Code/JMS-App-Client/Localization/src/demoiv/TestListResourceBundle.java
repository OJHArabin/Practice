/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demoiv;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author user
 */
public class TestListResourceBundle {
    public static void main(String args[]) throws InterruptedException
    {
        Locale locale=Locale.getDefault();
        ResourceBundle rb=ResourceBundle.getBundle("demoiv.ResBundle",locale);
        System.out.println(rb.getString("firstTime"));
         System.out.println(rb.getString("lastTime"));
        
        locale=new Locale("ne","Ne");
        ResourceBundle rbb=ResourceBundle.getBundle("demoiv.ResBundle_ne_Ne");
        System.out.println(rbb.getString("firstTime"));
        System.out.println(rbb.getString("lastTime"));
    }
}
