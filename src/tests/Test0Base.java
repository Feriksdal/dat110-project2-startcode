package tests;

import no.hvl.dat110.broker.Broker;
import no.hvl.dat110.broker.Dispatcher;
import no.hvl.dat110.broker.Storage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public abstract class Test0Base {

	// TODO: many possibilities for better testing
	protected Dispatcher dispatcher;
	protected Broker broker;
	protected Storage storage;
	
	protected int BROKER_TESTPORT = 8080;
	protected String BROKER_TESTHOST = "localhost";
	
	protected int RUNTIME = 10000; // time to allow test to execute
	
	@Before
	public void setUp() throws Exception {
		
		storage = new Storage();
		dispatcher = new Dispatcher(storage);
		broker = new Broker(dispatcher,BROKER_TESTPORT);
		
		dispatcher.start();
		broker.start();
		
		// allow broker to reaching waiting for incoming connections
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@After
	public void tearDown() throws Exception {
		
		try {
			Thread.sleep(10000); // let the system run for a while
			broker.join();
			dispatcher.doStop();
			dispatcher.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
