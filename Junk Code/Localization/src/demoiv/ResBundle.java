/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demoiv;

import java.util.ListResourceBundle;

/**
 *
 * @author user
 */
public class ResBundle extends ListResourceBundle
{

    @Override
    public Object[][] getContents() 
    {
        String[][] contents={
                    {"firstTime","Hello"},
                    {"lastTime","Bye"}
                  };
       return   contents;
    }
    
}
