/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jmsappclient;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author user
 */
public class ChatClient 
{ 
   @Resource(mappedName = "jms/FirstQueue")
    private static Destination firstQueue;
   
   @Resource(mappedName="jms/FirstConnectionFactory")
   private static ConnectionFactory firstConnectionFactory;
   
    @Resource(mappedName = "jms/FirstQueue")
    private static Destination secondQueue;
   
   @Resource(mappedName="jms/FirstConnectionFactory")
   private static ConnectionFactory secondConnectionFactory;
    public static void main(String args[])
    {
         try {
           Connection connectionA=null;
           Session sessionA=null;
           MessageConsumer messageConsumerA=null;
           Message msgA;
           TextMessage tmA=null;
           
           connectionA=firstConnectionFactory.createConnection();
           sessionA=connectionA.createSession(false,Session.AUTO_ACKNOWLEDGE);
           messageConsumerA=sessionA.createConsumer(firstQueue);
           MyListener myListenerA=new MyListener();
           messageConsumerA.setMessageListener(myListenerA);
           connectionA.start();
           System.out.println("Receiving message from sender....");
      /*    msg=messageConsumer.receive();
           if(msg instanceof TextMessage)
           {
               String message=((TextMessage)msg).getText();
               
               System.out.println("Message is "+message);
           } */
           System.out.println("Performing other tasks...");
       Connection connection=null;
       Session session=null;
       MessageProducer messageProducer=null;
       Message msg;
       TextMessage tm=null;
    //   String message="110/5";
       try {
           connection=secondConnectionFactory.createConnection();
           session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
           messageProducer=session.createProducer(secondQueue);
           tm=session.createTextMessage();
  
           
       } catch (JMSException ex) {
           Logger.getLogger(Producer1.class.getName()).log(Level.SEVERE, null, ex);
       }
       DataInputStream dis=new DataInputStream(System.in);
           while(true)
           {
               try
               {
                    System.out.println("Me(ChatClient):\t");
                String message=dis.readLine();
                tm.setText(message);
           msg=tm;
        //   System.out.println("Sending Message");
           messageProducer.send(msg);
        //   System.out.println("Message sent successfully");
               }
               catch(IOException e)
               {
                   System.err.println("IOError");
               }
           }
           
       } catch (JMSException ex) {
           Logger.getLogger(Consumer1.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
