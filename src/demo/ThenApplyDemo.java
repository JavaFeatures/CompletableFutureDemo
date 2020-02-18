package demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class ThenApplyDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Supplier<Integer> supplier = () -> 6;
		CompletableFuture<Integer> cFuture = CompletableFuture.supplyAsync(supplier).thenApply(num -> num * 2);
		int result = cFuture.get();
		System.out.println("Result: " + result);
	}

}
