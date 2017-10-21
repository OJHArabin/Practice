/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demooo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author user
 */
public class FileVisitor5
{
    public static void main(String args[])
    {
        try {
           // Path path=Paths.get("Testt").toRealPath().subpath(0, 3);
            Path path=Paths.get("E:/");
            Files.walkFileTree(path, new FileTraverser5("glob:A*.java"));
           
           
           
        } catch (IOException ex) {
          System.out.println("Error "+ex.getMessage());
        }
         
    }
}
