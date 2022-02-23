package tests;

import no.hvl.dat110.client.Client;
import org.junit.Test;

public class Test3MultipleConnections extends Test0Base {

	@Test
	public void test() {
		
	    broker.setMaxAccept(2);
		
		Client client1 = new Client("client1",BROKER_TESTHOST,BROKER_TESTPORT);
		
		Client client2 = new Client("client2",BROKER_TESTHOST,BROKER_TESTPORT);
		
		client1.connect();
		
		client2.connect();
		
		client1.disconnect();
		
		client2.disconnect();
	
	}
}
