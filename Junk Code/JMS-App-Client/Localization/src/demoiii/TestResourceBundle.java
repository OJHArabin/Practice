/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demoiii;

import java.util.Locale;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author user
 */
public class TestResourceBundle {
    public static void main(String argsp[])
    {
        Locale currentLocale=Locale.getDefault();
       // ResourceBundle rb=ResourceBundle.getBundle("ResourceBundle",currentLocale);
         ResourceBundle rb=ResourceBundle.getBundle("demoiii.ResourceBundle",currentLocale);
        System.out.println(rb.getString("Greeting"));
        
        Locale nepaliLocale=new Locale("ne");
         ResourceBundle rbn=ResourceBundle.getBundle("demoiii.ResourceBundle",nepaliLocale);
        System.out.println(rbn.getString("Greeting"));
        
         Locale nepaliLocalee=new Locale("in");
         ResourceBundle rbnn=ResourceBundle.getBundle("demoiii.ResourceBundle",nepaliLocalee);
        System.out.println(rbnn.getString("Greeting"));
        
        
    }
}
