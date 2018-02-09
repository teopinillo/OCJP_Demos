package concurrency;

//Regresa la suma de las raizes de los numeros en un Array.
//invoke, Fork Join Pool Left Right compute
import java.util.concurrent.*;
public class ForkJoinSqrExample {

	public static void main(String[] args) {
		int data[] = {2,45,67,58,59,40,30,20};
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		ConcurrentSqr c = new ConcurrentSqr (data,0,data.length);
		forkJoinPool.invoke(c);
		System.out.format("Result = %f",ConcurrentSqr.result);

	}

}
