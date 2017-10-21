package demooo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WatchServiceDemo {
    public static void main(String args[])
    {
        
       watch("E:",StandardWatchEventKinds.ENTRY_CREATE);
       watch("E:",StandardWatchEventKinds.ENTRY_MODIFY);
       watch("E:",StandardWatchEventKinds.ENTRY_DELETE);
       
       
    }
    public static void recordData(String fileName,String message)
    {
        try {
            FileWriter fw=new FileWriter(new File("G:/"+fileName), true);
            fw.write(message);
            fw.close();
        } catch (IOException ex) {
           System.out.println("Some error occured");
        }
    }
    public static void watch(String drive,Kind<Path> kind)
    {
         Path p=Paths.get(drive);
       // System.out.println(p.toAbsolutePath().normalize());
        WatchService ws=null;
         try {
                ws= p.getFileSystem().newWatchService(); //get a watch service from file system
               // ws=FileSystems.getDefault().newWatchService();
                p.register(ws, kind);   //register the path to the watch service
            } catch (IOException ex) {
                System.out.println("Error in registering"+ex.getMessage());
            }
          WatchKey key=null;
        while(true)
        {
     
          
            try {
                System.out.println("Looking for events");
                key=ws.take(); //watch for any key event
               //  key=ws.poll(); //watch for any key event
            } catch (InterruptedException ex) {
                System.out.println("Error "+ex.getMessage());
            }  /* */
         //  WatchKey key=ws.poll();
            for(WatchEvent<?> event:key.pollEvents()) //if the pooled events is not empty display the message
            {
                System.out.println("Some Events found");
                switch(event.kind().name()) 
                {
                    case "OVERFLOW":
                        System.out.println("Overflow occured");
                        break;
                    case "ENTRY_MODIFY":
                        String message1;
                        message1=new Date()+",";
                        recordData("Modify.csv",message1+","+event.context());
                        System.out.println(event.context() +" is changed");
                        break;
                    case "ENTRY_CREATE":
                        String message2;
                        message2=new Date()+",";
                        recordData("Create.csv",message2+","+event.context());
                        System.out.println(event.context()+" is created ");
                        break;
                    case "ENTRY_DELETE":
                        String message3;
                        message3=new Date()+",";
                        recordData("Delete.csv",message3+","+event.context());
                        System.out.println(event.context()+" is deleted");
                        break;
                }
            }
            key.reset();
        }
    }
}
