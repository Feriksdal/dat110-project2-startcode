package tests;

import no.hvl.dat110.client.Client;
import org.junit.Test;

public class Test5Subscribe extends Test0Base {

	public static String TESTTOPIC = "testtopic";
	
	@Test
	public void test() {
		
		broker.setMaxAccept(1);
		
		Client client = new Client("client",BROKER_TESTHOST,BROKER_TESTPORT);
		
		client.connect();
		
		client.createTopic(TESTTOPIC);
		
		client.subscribe(TESTTOPIC);
		
		client.unsubscribe(TESTTOPIC);
		
		client.disconnect();
	
		
	}

}
