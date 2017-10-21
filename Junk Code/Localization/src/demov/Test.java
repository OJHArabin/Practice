/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demov;

import java.io.DataInputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author user
 */
public class Test {
    public static void main(String[] args)
    {
        DataInputStream dis=new DataInputStream(System.in);
        int a=0,b=0,c=0;
        try
        {
        System.out.println("Enter any two numbers");
        a=Integer.parseInt(dis.readLine());
        b=Integer.parseInt(dis.readLine());
        c=a+b;
        
        Locale.setDefault(Locale.FRENCH);
        NumberFormat nf=NumberFormat.getCurrencyInstance();
        System.out.println(nf.format(c));
        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
        }
        catch(NumberFormatException e)
        {
            System.err.println(e.getMessage());
        }
        
    }
}
