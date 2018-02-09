package concurrency;

import java.util.concurrent.*;

@SuppressWarnings("serial")
public class ConcurrentSqr extends RecursiveAction {

	private static final int LIMIT = 3;
	static float result=0;
	int [] data;
	int start;
	int end;
	
	public ConcurrentSqr(int[] data, int start, int end) {
		this.data = data;
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		if ((end-start) < LIMIT ){
			for (int i=start; i<end;i++){
				result+=Math.sqrt(data[i]);
				System.out.println("Sqrt of " + data[i] +" = "+Math.sqrt(data[i]));
			}
				
			} else{
				int mid = (end+start)/2;
				ConcurrentSqr left = new ConcurrentSqr (data,start,mid);
				ConcurrentSqr right = new ConcurrentSqr (data,mid,end);
				left.fork();
				right.fork();
				left.join();
				right.join();
		}
		
	}

}
