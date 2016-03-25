package lt.ezz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component
public class Receiver {

	final static Logger logger = LoggerFactory.getLogger(Receiver.class);
	
    /**
     * Get a copy of the application context
     */
    @Autowired
    ConfigurableApplicationContext context;

    @Autowired
    JmsTransactionManager transactionManager;
    
    @Autowired
    JmsTemplate template;
    
    public void receiveMessage(String message) throws Exception {
    	

//    	throw new Exception("Bad input");
    }

    public void handleMessage(String msg) {
    	
    	logger.info("Msg received: " + msg);
    	TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
    	transactionManager.rollback( status );
    }

}
