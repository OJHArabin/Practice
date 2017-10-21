/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demooo;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class FileTraverser5 extends SimpleFileVisitor<Path>
{ 
    private PathMatcher matcher;
   
    int count=0;
        public FileTraverser5(String pattern)
        {
            try
            {
            matcher=FileSystems.getDefault().getPathMatcher(pattern);
            System.out.println(" Path matcher set");
            }
            catch(IllegalArgumentException e)
            {
                System.out.println("Error "+e.getMessage());
            }
        }
    @Override
    public FileVisitResult preVisitDirectory(Path t, BasicFileAttributes bfa) 
    {
        System.out.println("*********************************************************************");
        System.out.println("Going to visit "+t.getFileName()+" directory");
        System.out.println("*********************************************************************");
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path t, IOException ioe) throws IOException {
       System.out.println("*********************************************************************");
        System.out.println(t.getFileName()+" directory visited");
        System.out.println("*********************************************************************");
        return FileVisitResult.CONTINUE;
    }
   
    @Override
    public FileVisitResult visitFile(Path t, BasicFileAttributes bfa) 
    {
       
        if(matcher.matches(t.getFileName()))
        {
             count++;
                System.out.println(t.getFileName());
               
                  //  Path p=f.toPath().resolve("File"+count+".txt");
               
                if(count==1)
                {
                    File f1=new File("G:/nioTestt");
                        f1.mkdir();
                        System.out.println("New Directory created");
                }
                   File f=new File("G:/nioTestt/File"+count+".txt");  
                Path p=f.toPath();
                System.out.println(t.getFileName()+" copied to "+p.toString());
            try {
                Files.copy(t, p);
            } catch (IOException ex) {
                System.out.println("Error could not copy"+ex.getMessage());
            }
        }
       return FileVisitResult.CONTINUE;
    }

   
    
}
