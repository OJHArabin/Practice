
package demoo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Second {
    public static void main(String args[])
    {
        Path path1=Paths.get("C:/Users/user/Desktop/CPN/Suman/NonBlockingIODemo/Testt");
        Path path2=Paths.get("Testtt");
        System.out.println(path2.toAbsolutePath());
        
        System.out.println("***********************************************");
         System.out.println(path1.equals(path2));
         System.out.println(path1.compareTo(path2));
         System.out.println("***********************************************");
         System.out.println(path2.normalize().toAbsolutePath().equals(path1));
         System.out.println(path2.normalize().toAbsolutePath().compareTo(path1));
   //System.out.println(Files.isSameFile(path2, path1));
         
//      
//        
    //    System.out.println("******************Inside try*****************************");
  
      
          try 
          {
         // System.out.println(Files.isSameFile(path2, path1));
        
              if(Files.exists(path2, LinkOption.NOFOLLOW_LINKS))
            System.out.println(Files.isSameFile(path2, path1));
            else
            System.out.println("The specied file doesn't exist");
//           
               if(Files.isDirectory(path2,  LinkOption.NOFOLLOW_LINKS))
                    {
                        System.out.println("It is directory");
                    }
               else
                   System.out.println("It isn't a directory");
   
            if(Files.exists(path2, LinkOption.NOFOLLOW_LINKS))
            {
                 System.out.println(Files.isSameFile(path2, path1));
                    if(Files.isDirectory(path2,  LinkOption.NOFOLLOW_LINKS))                    {
                        System.out.println("It is directory");
                    }  
            }
           
            else
                System.out.println("The specied file doesn't exist");
      
//     
      
        /* */          
////         
      } 
          catch (IOException ex)
        {
            System.out.println("Error in "+ex.getMessage());
        }
//          
    } 
}
