package condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Me {

	public static void main(String[] args) {
		final Lock lock = new ReentrantLock();
		final Condition kitchenOff = lock.newCondition();
		
		
		Thread kitchen = new Thread( new Kitchen (lock,kitchenOff));	
		kitchen.setName("Kitchen");
		
		Thread akira = new Thread ( new Akira (lock, kitchenOff));
		akira.setName("Akira");
		
		lock.lock();
		try {	
			akira.start();
			Thread.sleep(1000);
			kitchen.start();
			
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		 
		 
		 
	}

}
