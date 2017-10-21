/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

/**
 *
 * @author user
 */
public class FileTraverser3 extends SimpleFileVisitor<Path>
{ 
   
    int count=0;
   
    @Override
    public FileVisitResult visitFile(Path t, BasicFileAttributes bfa) 
    {
      
        if(t.getFileName().toString().endsWith(".jpg"))
        {
                count++;
              //  System.out.println(t.getFileName());
               
                  //  Path p=f.toPath().resolve("File"+count+".txt");
               
                if(count==1)
                {
                        File f1=new File("G:/All Images");
                        f1.mkdir();
                        System.out.println("New Directory created");
                }
              
            
            try {
                  Object o=Files.getAttribute(t, "creationTime", LinkOption.NOFOLLOW_LINKS);
                   File f=new File("G:/All Images/"+normalize(o.toString())+".jpg");  
                   Path p=f.toPath();
                    Files.copy(t, p);
                    System.out.println(t.getFileName()+" copied to "+p.toString());
            } catch (IOException ex) {
                System.out.println("Error could not copy"+ex.getMessage());
            }
        }
       return FileVisitResult.CONTINUE;
    }

    public String normalize(String value)
    {
        //value.
        String[] sArray=value.split(":");
            String result="";
            for(String st:sArray)
            {
                result=result+st;
                System.out.println(st);
            }
       return result;
    }
    
}
