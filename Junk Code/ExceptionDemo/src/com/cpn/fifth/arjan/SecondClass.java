
package com.cpn.fifth.arjan;

import java.io.DataInputStream;
import java.io.IOException;

public class SecondClass 
{
    public static void main(String[] arr)
    {
        Integer a=0,b=0,c=0;
        
        DataInputStream dis=new DataInputStream(System.in);
        try
        {
            System.out.println("Enter any two numbers");
            a=Integer.parseInt(dis.readLine());
            b=Integer.parseInt(dis.readLine());
            c=a+b;
            System.out.println("The sum is "+c);
        }
        catch(IOException ex)
        {
            System.out.println("IO Error "+ex.getMessage());
        }
        
    }
}
