/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoii;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author user
 */
public class TestClass {
    public static void main(String[] args) {
        
        Locale.setDefault(new Locale("ne"));
        Date d=new Date();
        //for displaying date we get a dateFormat instance and format it with required locale
         DateFormat df= DateFormat.getDateInstance();
        System.out.println(df.format(d));
        
        ResourceBundle rb=ResourceBundle.getBundle("demoii.ResourceBundle");
        System.out.println(rb.getString("message"));
    }
}
