/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jmsappclient;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author user
 */
public class Producer1 {

   @Resource(mappedName = "jms/FirstQueue")
    private static Destination firstTopic;
   
   @Resource(mappedName="jms/FirstConnectionFactory")
    private static ConnectionFactory firstConnectionFactory;
    public static void main(String[] args)
    {
       Connection connection=null;
       Session session=null;
       MessageProducer messageProducer=null;
       Message msg;
       TextMessage tm=null;
       String message="110/6";
       try {
           connection=firstConnectionFactory.createConnection();
           session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
           messageProducer=session.createProducer(firstTopic);
           tm=session.createTextMessage();
           tm.setText(message);
           msg=tm;
           System.out.println("Sending Message");
           messageProducer.send(msg);
           System.out.println("Message sent successfully");
           
       } catch (JMSException ex) {
           Logger.getLogger(Producer1.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    }
    
}
