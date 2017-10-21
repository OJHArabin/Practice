/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demooo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class FileVisitor2 {
    public static void main(String args[])
    {
        try {
           // Path path=Paths.get("Testt").toRealPath().subpath(0, 3);
            Path path=Paths.get("E:/");
            Files.walkFileTree(path, new FileTraverser2());
            
            
        } catch (IOException ex) {
          System.out.println("Error "+ex.getMessage());
        }
         
    }
}
