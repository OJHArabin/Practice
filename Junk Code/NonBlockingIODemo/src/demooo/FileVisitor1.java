
package demooo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileVisitor1 {
    public static void main(String args[])
    {
        try {
           
            Path path=Paths.get("E:/");
            Files.walkFileTree(path, new FileTraverser1());
        } catch (IOException ex) {
          System.out.println("Error "+ex.getMessage());
        }
         
    }
}
