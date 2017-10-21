/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpn.rich;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author user
 */
public class QueueConsumerSync {
  @Resource(mappedName = "jms/SandipT")
    private static Destination richaQueue;
   
   @Resource(mappedName="jms/MadhurCF")
    private static ConnectionFactory richaConnectionFactory;
    public static void main(String args[])
    {
       try {
           Connection connection=null;
           Session session=null;
           MessageConsumer messageConsumer=null;
           Message msg;
           TextMessage tm=null;
           
           connection=richaConnectionFactory.createConnection();
           session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
           messageConsumer=session.createConsumer(richaQueue);
           
            connection.start();
            System.out.println("Receiving message from sender....");
            msg=messageConsumer.receive();
           if(msg instanceof TextMessage)
           {
               String message=((TextMessage)msg).getText();
               
               System.out.println("Message is "+message);
           }
           /*  System.out.println("Receiving message from sender....");
           MyListener myListener=new MyListener();
           messageConsumer.setMessageListener(myListener);
           connection.start();
         
          msg=messageConsumer.receive();
           if(msg instanceof TextMessage)
           {
               String message=((TextMessage)msg).getText();
               
               System.out.println("Message is "+message);
           } 
           System.out.println("Performing other tasks...");
         while(true)
                 {
                     
                 }
                   */
           
       } catch (JMSException ex) {
           Logger.getLogger(TopicConsumerSyn.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
