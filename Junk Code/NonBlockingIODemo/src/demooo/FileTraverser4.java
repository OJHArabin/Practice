
package demooo;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileTraverser4 extends SimpleFileVisitor<Path>
{ 
   
    int count=0;

    @Override
    public FileVisitResult preVisitDirectory(Path t, BasicFileAttributes bfa) 
    {
        System.out.println("*********************************************************************");
        System.err.println("Going to visit "+t.getFileName()+" directory");
        System.out.println("*********************************************************************");
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path t, IOException ioe) throws IOException {
       System.out.println("*********************************************************************");
        System.err.println(t.getFileName()+" directory visited");
        System.out.println("*********************************************************************");
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path t, IOException ioe) throws IOException {
        System.err.println("Visit file failed");
        return FileVisitResult.CONTINUE;
    }
   
    @Override
    public FileVisitResult visitFile(Path t, BasicFileAttributes bfa) 
    {
       
        if(t.getFileName().toString().endsWith(".wmv"))
        {
             count++;
                System.out.println(t.getFileName());
               
                  //  Path p=f.toPath().resolve("File"+count+".txt");
               
                if(count==1)
                {
                    File f1=new File("G:/Videos");
                        f1.mkdir();
                        System.out.println("New Directory created");
                }
                   File f=new File("G:/Videos/"+count+".txt");  
                Path p=f.toPath();
               
            try {
                Files.copy(t, p);
                 System.out.println(t.getFileName()+" copied to "+p.toString());
            } catch (IOException ex) {
                System.out.println("Error could not copy"+ex.getMessage());
            }
        }
       return FileVisitResult.CONTINUE;
    }

   
    
}
