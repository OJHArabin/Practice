

package nonblockingiodemo;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NonBlockingIODemo {

    public static void main(String[] args) {
      Path p=Paths.get("E:\\try\\tryy\\test.txt");
      System.out.println("E:\\try\\tryy\\test.txt");
      System.out.println("The file name is "+p.getFileName());
      System.out.println("The file system is" +p.getFileSystem());
      System.out.println("The 0 name is " +p.getName(0));
      System.out.println("The name count is " +p.getNameCount());
      System.out.println("The parent is "+ p.getParent());
      System.out.println("The root is "+p.getRoot());
   
      System.out.println("The elements of path using foreach loop");
      for(Path pp: p)
      {
          System.out.println(pp);
      }
    
      System.out.println("The elements of path using for loop");
      int l=p.getNameCount();
      for(int i=0;i<l;i++)
      {
          System.out.println(p.getName(i));
      }
            /*  */
    }
    
}
