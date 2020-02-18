package demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AnyOfDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> cFuture1 = CompletableFuture.supplyAsync(() -> "This ");
		CompletableFuture<String> cFuture2 = CompletableFuture.supplyAsync(() -> "is a ");
		CompletableFuture<String> cFuture3 = CompletableFuture.supplyAsync(() -> "Java ");
		CompletableFuture<String> cFuture4 = CompletableFuture.supplyAsync(() -> "Program");
		CompletableFuture<Object> combinedFuture = CompletableFuture.anyOf(cFuture1, cFuture2, cFuture3, cFuture4);
		String result = (String)combinedFuture.get();
		System.out.println("Result: " + result);
	}

}
