package concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(1);
		Thread_A thread_A = new Thread_A (semaphore," JUAN ");
		Thread_A thread_B = new Thread_A (semaphore," PETER ");
		Thread_A thread_C = new Thread_A (semaphore," ALEX ");
		
		thread_A.start();
		thread_B.start();
		thread_C.start();
	}

}
