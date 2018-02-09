package condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


public class Akira implements Runnable {
	private Condition kitchenOff;
	Lock lock;
	
	public Akira (Lock _lock, Condition _kitchenOff){
		lock = _lock;
		kitchenOff = _kitchenOff;
	}
	public void run(){
		lock.lock();
		 try{
			 System.out.println("Akira: waiting for the kitchen to be off!");
			 
			 //kitchenOff.await();
			 kitchenOff.awaitNanos(8000);
			 System.out.println("Akira: kitchen is off! I am going now");
		 }catch (Exception e){
			 e.printStackTrace();
		 }finally {
			lock.unlock();
		 }
	}

}
