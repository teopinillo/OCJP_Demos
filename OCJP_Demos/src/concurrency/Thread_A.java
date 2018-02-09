package concurrency;

import java.util.concurrent.Semaphore;

public class Thread_A extends Thread {

	private Semaphore semaphore;
	private String name;
	
	
	@Override
	public void run(){
		System.out.println (name + " enter to run");
		try {
			System.out.println (name + " trying to acquire");
			semaphore.acquire();
			System.out.println(name + " resource adquiered. Doing Job");
			sleep (2000);
			semaphore.release();
			System.out.println(name + " resource realesed");			
		}catch (InterruptedException ie){
			System.out.println(ie.getMessage());
		}
		
	}
	
	public Thread_A (Semaphore s, String _name){
		semaphore = s;
		name = _name;
	}
	

}
