package com.caveofprogramming;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App_008_ProducerConsumer {
	
	//Is thread safe.
	private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	public static volatile boolean continuing = true;

	public static void main(String[] args) throws InterruptedException {
		
		App_008_ProducerConsumer myApp = new App_008_ProducerConsumer();
		Consumer consumerTh = myApp.new Consumer();
		Producer producerTh = myApp.new Producer();
		ExecutorService executor = Executors.newFixedThreadPool (2);
		executor.submit(consumerTh);
		executor.submit(producerTh);
		
		try {
	    executor.awaitTermination(5, TimeUnit.SECONDS);
	    continuing = false;
	    executor.shutdown();	  
	     while (!executor.isTerminated())executor.shutdown();
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("Program ends.");
		
		

	}

	public class Producer implements Runnable {
		@Override 
		public void run(){
			producer();
		}
	}
	
	public class Consumer implements Runnable {
		@Override
		public void run(){
			consumer();
		}
	}
	
	public void producer(){
		Random random = new Random();
		while (continuing){
			try {
				//integers up to 1000
				//put: if the queue is full, waits until can insert
				int i = random.nextInt(1000);
				queue.put(i);
				System.out.println("put in queue: "+ i);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}
	
	private void consumer(){
		Random random = new Random();
		while (continuing){
			try{
				//Simulating processing
				Thread.sleep(1000);
				while (random.nextInt(10)==7){
					//waits until an element is in the queue
					Integer value = queue.take();
					System.out.println("take from queue: "+ value);
				}
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
