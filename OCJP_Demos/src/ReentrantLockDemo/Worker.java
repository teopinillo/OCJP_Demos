package ReentrantLockDemo;

public class Worker implements Runnable {

	Task task;
	Worker (Task task){
		this.task = task;
	}
	
	@Override
	public void run(){
		task.performTask();
	}
}
