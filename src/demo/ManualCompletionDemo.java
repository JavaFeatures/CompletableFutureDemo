package demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class ManualCompletionDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Supplier<String> supplier = () -> {
			System.out.println("In Thread body");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Hello World";
		};
		System.out.println("In main starting new Thread");
		CompletableFuture<String> cFuture = CompletableFuture.supplyAsync(supplier);
		System.out.println("In main doing something else");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (!cFuture.isDone()) {
			System.out.println("Thread is not complete so completing manually");
			cFuture.complete("Hello World 2");
		}
		String result = cFuture.get();
		System.out.println("Result from Thread: " + result);
		System.out.println("Main completed");
	}

}
