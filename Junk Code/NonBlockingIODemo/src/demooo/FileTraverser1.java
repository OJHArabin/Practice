

package demooo;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author user
 */
public class FileTraverser1 extends SimpleFileVisitor<Path>
{

    @Override
    public FileVisitResult visitFile(Path t, BasicFileAttributes bfa) throws IOException
    {
//        if(Files.isDirectory(t,  LinkOption.NOFOLLOW_LINKS))
//            System.out.println("*****Directory******");
       System.out.println(t.getFileName());
       return FileVisitResult.CONTINUE;
    }
//
//    @Override
//    public FileVisitResult preVisitDirectory(Path t, BasicFileAttributes bfa) throws IOException {
//         System.out.println(t.getFileName());
//        return FileVisitResult.CONTINUE; //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public FileVisitResult postVisitDirectory(Path t, IOException ioe) throws IOException {
//        System.out.println(t.getFileName());
//        return FileVisitResult.SKIP_SUBTREE;
//    }
    
    

  

   
    
}
