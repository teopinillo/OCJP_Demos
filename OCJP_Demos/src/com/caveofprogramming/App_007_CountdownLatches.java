package com.caveofprogramming;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App_007_CountdownLatches {
	
	class Processor implements Runnable {
		private CountDownLatch count;
		
		public Processor (CountDownLatch count){
			this.count = count;
		}
		@Override
		public void run(){
			System.out.println("start: "+Thread.currentThread().getName());
			
			//simulating operations
			try{
				Thread.sleep(2000);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
			//decrementing the latch
			count.countDown();
			
			System.out.println("end: "+Thread.currentThread().getName());
			
		}
	}

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		 App_007_CountdownLatches myApp = new  App_007_CountdownLatches();
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for (int i=0;i<3;i++){			
			executor.submit (myApp. new Processor(latch));
		}
		
		//wait until all thread finish, by counting down 
		
		try{
		latch.await();
		}catch (InterruptedException e){
			e.printStackTrace();
		}

		System.out.println("finish main Thread");
		executor.shutdown();
	}

}
