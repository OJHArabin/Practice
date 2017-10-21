
package demoo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Third {
    public static void main(String args[])
    {
        Path p= Paths.get("./test/test.txt");
        if(Files.exists(p, LinkOption.NOFOLLOW_LINKS))
        {
                System.out.println("The file exists");
                System.out.println("The attributes are");
                System.out.printf("\nRead permission %b %n",Files.isReadable(p));
                System.out.printf("\nWrite permission %b%n",Files.isWritable(p));
                 System.out.printf("\nExecutable file %b%n",Files.isExecutable(p));
                 
                
                
            try
            {
                System.out.printf("\nHidden file %b%n",Files.isHidden(p));
            } 
            catch (IOException ex) {
                System.out.println("An IO Error Occured \n"+ex.getMessage());
            }
        }
        else
            System.out.println("The file doesn't exist");
    }
}
