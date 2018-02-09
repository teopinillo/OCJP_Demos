package concurrency;

import java.util.concurrent.CountDownLatch;

public class Thread_B extends Thread {

	
	private String name;
	private CountDownLatch countDownLatch;
	private String job;
	
	@Override
	public void run(){
		System.out.println (name + " enter to run");
		try {
			System.out.println (name + " trying to acquire");
			countDownLatch.await();
			System.out.println(name + " resource adquiered. Doing Job");
			sleep (2000);
			for (int i=1;i<40;i++){
				System.out.print (job);
			}
			System.out.println (job);
			
		}catch (InterruptedException ie){
			System.out.println(ie.getMessage());
		}
		
	}
	
	public Thread_B (CountDownLatch c, String _name, String _job){
		countDownLatch = c;
		name = _name;
		job = _job;
	}

	

}
