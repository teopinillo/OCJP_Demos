package concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch (10);
		Thread_B thread_a = new Thread_B (countDownLatch,"Chevy -","-");
		Thread_B thread_b = new Thread_B (countDownLatch,"Dodge *","*");
		Thread_B thread_c = new Thread_B (countDownLatch,"Fiat |","|");
		thread_a.start();
		thread_b.start();
		thread_c.start();
		
		for (int i=0;i<10;i++){
			countDownLatch.countDown();
			try {
				Thread.sleep(1000);
				System.out.print(i + ".");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		System.out.println();
	}

}
