package demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AllOfDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> cFuture1 = CompletableFuture.supplyAsync(() -> "This ");
		CompletableFuture<String> cFuture2 = CompletableFuture.supplyAsync(() -> "is a ");
		CompletableFuture<String> cFuture3 = CompletableFuture.supplyAsync(() -> "Java ");
		CompletableFuture<String> cFuture4 = CompletableFuture.supplyAsync(() -> "Program");
		CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(cFuture1, cFuture2, cFuture3, cFuture4);
		combinedFuture.get();
	}

}
