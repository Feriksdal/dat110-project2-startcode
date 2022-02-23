package tests;

import no.hvl.dat110.client.Client;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Test4CreateDelete extends Test0Base {

	private static String TESTTOPIC = "testtopic";
	
	@Test
	public void test() {
				
		Client client = new Client("client",BROKER_TESTHOST,BROKER_TESTPORT);
		
		broker.setMaxAccept(1);
		
		client.connect();
		
		client.createTopic(TESTTOPIC);
		
		client.deleteTopic(TESTTOPIC);
		
		client.disconnect();
	
		assertTrue(true);
	}

}
