package concurrency;

//Used for Executor example

import java.util.Random;

public class Order implements Runnable {

	@Override
	public void run() {
		Random r = new Random();
		int order = r.nextInt();
		System.out.println ("Order #: "+ order);
	}

}
