

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

public class Consumer1 
{
    
 
   @Resource(mappedName = "jms/PrakashTopic")
    private static Destination firstTopic;
   
   @Resource(mappedName="jms/PrakashConnectionFactory")
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
           messageConsumer=session.createConsumer(firstTopic);
           
           connection.start();
           System.out.println("Receiving message from sender....");
           msg=messageConsumer.receive();
           if(msg instanceof TextMessage)
           {
               String message=((TextMessage)msg).getText();
               
               System.out.println("Message is "+message);
           }
       } catch (JMSException ex) {
           Logger.getLogger(Consumer1.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}
