package ReentrantLockDemo;

import java.util.concurrent.locks.ReentrantLock;

public class LockUnlockDemo implements Task {
	final ReentrantLock reentrantLock = new ReentrantLock();
	
	
	@Override
	public void performTask(){
		reentrantLock.lock();
		 try{
			 System.out.println(Thread.currentThread().getName()+ ": lock acquired");
			 System.out.println("Processing...");
			 Thread.sleep(2000);
			 
		 }catch (InterruptedException e){
			 e.printStackTrace();			 
		 }finally {
			 reentrantLock.unlock();
		 }
	}

}
