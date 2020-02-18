package demo;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class ThenAcceptDemo {

	public static void main(String[] args) {
		Supplier<String> supplier = () -> {
			System.out.println("In Thread body");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Hello";
		};
		System.out.println("In main starting new Thread");
		CompletableFuture.supplyAsync(supplier).thenAccept(str -> System.out.println(str + " World"));
		System.out.println("In main doing something else");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main completed");
	}

}
