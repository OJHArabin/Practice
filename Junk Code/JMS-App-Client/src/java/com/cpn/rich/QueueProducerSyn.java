
package com.cpn.rich;

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
public class QueueProducerSyn {
    @Resource(mappedName = "jms/MadhurQ")
    private static Destination richaQueue;
   
   @Resource(mappedName="jms/MadhurCF")
    private static ConnectionFactory richaConnectionFactory;
    public static void main(String[] args)
    {
       Connection connection=null;
       Session session=null;
       MessageProducer messageProducer=null;
       Message msg;
       TextMessage tm=null;
       String message="126/5";
       try {
           connection=richaConnectionFactory.createConnection();
           session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
           messageProducer=session.createProducer(richaQueue);
           
           tm=session.createTextMessage();
           tm.setText(message);
           msg=tm;
           System.out.println("Sending Message");
           messageProducer.send(msg);
           System.out.println("Message sent successfully");
           
       } catch (JMSException ex) {
           Logger.getLogger(QueueProducerSyn.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    }
}
