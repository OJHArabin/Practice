
package test;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class keyApp 
{
     public static void main(String args[]) {
     JFrame frame = new JFrame("Key Listener");
     Container contentPane = frame.getContentPane();

  KeyListener listener = new KeyListener() 
  {
    @Override

    public void keyPressed(KeyEvent event) 
    {
        printEventInfo("Key Pressed", event);
    }

    @Override

    public void keyReleased(KeyEvent event) 
    {
        System.out.println("");
    }

    @Override

    public void keyTyped(KeyEvent event) 
    {
        System.out.println("");
    }

private void printEventInfo(String str, KeyEvent e) 
{
    int code = e.getKeyCode();
//    System.out.println(str);
    System.out.println("   Code: " + KeyEvent.getKeyText(code));
    try{
        FileWriter fw=new FileWriter(new File("E:/keyApp.txt"),true);
        fw.write(KeyEvent.getKeyText(code));
        fw.close();
        
    }
    catch (IOException ex)
    {
      System.out.println("some error occured"+ex.getMessage());
    }
}



  };
  JTextField textField = new JTextField();
  textField.addKeyListener(listener);
  contentPane.add(textField, BorderLayout.NORTH);
  frame.pack();
  frame.setVisible(true);
    }

}

