package demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class SupplyAsyncDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Supplier<String> supplier = () -> {
			System.out.println("In Thread body");
			return "Hello World";
		};
		System.out.println("In main starting new Thread");
		CompletableFuture<String> cFuture = CompletableFuture.supplyAsync(supplier);
		System.out.println("In main doing something else");
		System.out.println("In main waiting for Thread result");
		String result = cFuture.get();
		System.out.println("Result from Thread: " + result);
		System.out.println("Main completed");
	}

}
