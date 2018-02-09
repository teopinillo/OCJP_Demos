package concurrency;
import java.util.concurrent.*;

//11/04/2017
//Practicing ForkJoinDemo
// A simple fork join demo to sum a number
// What we are trying to achieve in the example is we have an array of integers. I want the sum of square of the elements of array

public class ForkJoinDemo2 {

	public static int result=0;

	public static void main(String[] args) {
		
		int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int start = 0;
		int end = data.length;
		
		ForkJoinDemo2 myApp = new ForkJoinDemo2();
		Square square = myApp. new Square (data,start,end);
		
		ForkJoinPool forkJoinPool = new ForkJoinPool ();
		forkJoinPool.invoke(square);
		System.out.println(result);
		
	}

	 class Square extends RecursiveAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 8118172173207173839L;
		final int LIMIT = 3;
		int[] data;
		int start;
		int end;
		

		@Override
		protected void compute() {
			if ((end - start) < LIMIT) {
				for (int i = start; i < end; i++) {
					result += data[i] * data[i];
				}
			} else {
				int mid = (start + end) / 2;
				Square squareL = new Square (data,start,mid);
				Square squareR = new Square (data,mid,end);
				squareL.fork();
				squareR.fork();
				squareL.join();
				squareR.join();

			}

		}

		Square(int[] data, int start, int end) {
			this.data = data;
			this.start = start;
			this.end = end;			
		}

	}
}