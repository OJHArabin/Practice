
package com.cpn.fifth.arjan;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StackTraceDemo
{
    public static void main(String[] args)
    {
        try 
        {
            a();
        } catch (IOException ex) 
        {
            
            StackTraceElement[] stackTraceElementArray=ex.getStackTrace();
            for(StackTraceElement stackTraceElement:stackTraceElementArray)
            {
                System.out.println(stackTraceElement.getMethodName());
            }
        }
    }
    public static  void a()throws IOException
    {
        aa();
    }
    public static  void aa() throws IOException
    {
        aaa();
    }
    public static  void aaa() throws IOException
    {
        aaaa();
    }
    public static  void aaaa() throws IOException
    {
        throw new IOException();
    }
}
