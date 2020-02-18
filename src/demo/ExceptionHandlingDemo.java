package demo;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExceptionHandlingDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<Integer> cFuture = CompletableFuture.supplyAsync(() -> {
			int num = new Random(100).nextInt();
			System.out.println("Number: " + num);
			if (num < 100) {
				throw new RuntimeException("Incorrect number");
			}
			else {
				return num;
			}
		}).exceptionally(ex -> {
			System.out.println("Exception thrown: " + ex.getMessage());
			return 0;
		});
		int result = cFuture.get();
		System.out.println("Result: " + result);
	}

}
