

package sambandh;

import jmsappclient.*;
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

public class Consumer 
{
    
   @Resource(mappedName = "jms/SambandhQueue")
    private static Destination firstQueue;
   
   @Resource(mappedName="jms/SambandhConnFactory")
    private static ConnectionFactory firstConnectionFactory;
    public static void main(String args[])
    {
       try {
           Connection connection=null;
           Session session=null;
           MessageConsumer messageConsumer=null;
           Message msg;
           TextMessage tm=null;
           
           connection=firstConnectionFactory.createConnection();
           session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
           messageConsumer=session.createConsumer(firstQueue);
           
           connection.start();
           System.out.println("Receiving message from sender....");
           msg=messageConsumer.receive();
           System.out.println("Message Received");
           if(msg instanceof TextMessage)
           {
               String message=((TextMessage)msg).getText();
               
               System.out.println("Message is "+message);
           }
       
       } catch (JMSException ex) {
           Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}
