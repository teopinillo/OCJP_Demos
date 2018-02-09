package ReentrantLockDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		final int threadsCount = 5;
		final ExecutorService es = Executors.newFixedThreadPool(threadsCount);
		final LockUnlockDemo task = new LockUnlockDemo();
		 for (int i=0; i<threadsCount; i++){
			 es.execute(new Worker(task));
		 }
		 es.shutdown();	
		 
	}

}
