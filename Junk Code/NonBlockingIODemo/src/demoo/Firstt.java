

package demoo;

import demoo.*;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Firstt {
    public static void main(String... argsp)
    {
       Path p=Paths.get("");
       System.out.println(p);
// 
      System.out.println("The file name is "+p.getFileName());
       System.out.println("The file system is" +p.getFileSystem());
       System.out.println("The 0 name is " +p.getName(0));
       System.out.println("The name count is " +p.getNameCount());
       System.out.println("The parent is "+ p.getParent());
       System.out.println("The root is "+p.getRoot());
//// 
      System.out.println("The uRI is "+p.toUri());
     System.out.println("The absolute path is "+p.toAbsolutePath());
     System.out.println("The normalized path is "+p.normalize());
     System.out.println("Uri normalized "+p.toUri().normalize());
     System.out.println("Absolute path normalized  is "+p.toAbsolutePath().normalize());
////    
         try
           {
            System.out.println("Normalized real path is "+p.toRealPath(LinkOption.NOFOLLOW_LINKS));
           } 
           catch (IOException ex)
            {
            System.out.println("Request Resource Not Found\n"+ex.getMessage());
            }
              /* */
   }
}
