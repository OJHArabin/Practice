/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demooo;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author user
 */
public class FileTraverser2 extends SimpleFileVisitor<Path>
{

    @Override
    public FileVisitResult visitFile(Path t, BasicFileAttributes bfa) throws IOException
    {
        if(t.getFileName().toString().endsWith(".jpg"))
       System.out.println(t.getFileName());
       return FileVisitResult.CONTINUE;
    }

   
    
}
