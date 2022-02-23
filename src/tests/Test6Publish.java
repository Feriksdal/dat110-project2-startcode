package tests;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.PublishMsg;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test6Publish extends Test0Base {

	public static String TESTTOPIC = "testtopic";
	
	@Test
	public void test() {
		
		broker.setMaxAccept(1);
		
		Client client = new Client("client",BROKER_TESTHOST,BROKER_TESTPORT);
		
		client.connect();
		
		client.createTopic(TESTTOPIC);
		
		client.subscribe(TESTTOPIC);
		
		client.publish(TESTTOPIC, "message from client on topic");
		
		PublishMsg msg = (PublishMsg)client.receive();

		client.unsubscribe(TESTTOPIC);
		
		client.disconnect();

		assertEquals("message from client on topic",msg.getMessage());
	
	}

}
