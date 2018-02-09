/**
 * 
 */
package com.caveofprogramming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author tfrancisco
 *  Threads Pools
 */
public class App_006 {

	public class Processor implements Runnable {
		private int id;
		
		public Processor (int i){
			id = i;
		}
		@Override
		public void run (){
			System.out.println("Start Thread: "+id);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			
			System.out.println("End Thread: "+id);

		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		App_006 myApp = new App_006();
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for (int i=0;i<5;i++){
			executor.submit ( myApp. new Processor (i));
		}
		executor.shutdown();
		
		//another variant
		/*
		try {
			executor.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

}
