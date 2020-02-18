package demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> cFuture = new CompletableFuture<String>();
		CompletableFuture<String> cFuture1 = CompletableFuture.completedFuture("Hello World");
		String result1 = cFuture1.get();
		System.out.println("Result: " + result1);
		String result = cFuture.get();
		System.out.println("Result: " + result);
	}

}
