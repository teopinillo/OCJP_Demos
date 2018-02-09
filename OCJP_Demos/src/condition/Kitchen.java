package condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


public class Kitchen implements Runnable {
	
	private Condition kitchenOff;
	private Lock lock;
	
	public Kitchen (Lock _lock, Condition _kitchenOff) {		
		kitchenOff = _kitchenOff;
		lock = _lock;
	}
		
	public void run(){
		
	 lock.lock();
		 try {
			 
			 System.out.println("Kitchen: Turning off the Kitchen...");
			 Thread.sleep (3000);
			 System.out.println("Kitchen: every thing is off.");
			 kitchenOff.signalAll();
			 
			 //lock.notifyAll();	 
		 }catch (Exception e){
			 e.printStackTrace();
		 }finally {
			lock.unlock();
		 }
	}
}
