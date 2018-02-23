package concurrency;

import java.util.ArrayList;
import java.util.concurrent.Executor;

public class Executor_Demo implements Executor {

	@Override
	public void execute(Runnable r) {
		new Thread (r).start();
	}

	public static void main(String[] args) {
		Executor_Demo myApp = new Executor_Demo();
		ArrayList <Order> orders = new ArrayList<>();
		 //creates 10 orders
		 for (int i=0;i<10;i++)
		 orders.add(new Order());
		 //call the orders
		 for (Order o:orders) {
			 myApp.execute(o);			 
		 }

	}

}
