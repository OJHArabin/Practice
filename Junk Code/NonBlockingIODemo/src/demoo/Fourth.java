/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demoo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Fourth {
    public static void main(String args[])
    {
        Path p= Paths.get("./test/test.txt");
        try {
            Object o=Files.getAttribute(p, "creationTime", LinkOption.NOFOLLOW_LINKS);
            String s=o.toString();
            
           
            System.out.println("Creation Time"+o);
             o=Files.getAttribute(p, "lastModifiedTime", LinkOption.NOFOLLOW_LINKS);
            System.out.println("Last Modified Time"+o);
        } catch (IOException ex) {
            Logger.getLogger(Fourth.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
