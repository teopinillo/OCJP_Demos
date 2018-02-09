package com.caveofprogramming;

public class App_003 {

	public static void main(String[] args) {
		Thread t = new Thread (new Runnable() {
			@Override
			public void run(){
				for (int i=0; i<10;i++){			
					System.out.println("Hello " + i);
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {				
						e.printStackTrace();
					}
				}
			}
		});
		t.start();
	}

}
