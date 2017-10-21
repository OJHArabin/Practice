

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
public class FileVisitor4
{
    public static void main(String args[])
    {
        try {
           // Path path=Paths.get("Testt").toRealPath().subpath(0, 3);
            Path path=Paths.get("C:\\Users\\user\\Desktop\\CPN");
            Files.walkFileTree(path, new FileTraverser4());
           
           
           
        } catch (IOException ex) {
          System.out.println("Error "+ex.getMessage());
        }
         
    }
}
