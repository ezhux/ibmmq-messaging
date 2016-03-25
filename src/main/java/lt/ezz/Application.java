
package lt.ezz;

import java.io.File;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.util.FileSystemUtils;

@SpringBootApplication
@ImportResource("classpath:spring-beans.xml")
@EnableJms
public class Application {
	
    @Bean // Strictly speaking this bean is not necessary as boot creates a default
    JmsListenerContainerFactory<?> myJmsContainerFactory( ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

    public static void main(String[] args) throws InterruptedException {
        // Launch the application
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        for (int i = 0; i < 50; i++) {
        	Thread.sleep(1000);
        	System.out.println("sleeping");
        }
        
//        // Send a message
//        MessageCreator messageCreator = new MessageCreator() {
//            @Override
//            public Message createMessage(Session session) throws JMSException {
//                return session.createTextMessage("ping!");
//            }
//        };
//        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
//        System.out.println("Sending a new message.");
//        jmsTemplate.send("mailbox-destination", messageCreator);
    }

}
