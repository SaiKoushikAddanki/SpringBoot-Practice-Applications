package com.epam.practice.oops;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.epam.practice.service.RandomNumCallable;
import com.epam.practice.service.RandomNumberGeneratorService;

public class MultiThreadingPractice {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int coreCount = Runtime.getRuntime().availableProcessors();
		System.out.println("Number of cores are:" + coreCount);
		ExecutorService service = Executors.newFixedThreadPool(coreCount);
		RandomNumberGeneratorService generator = new RandomNumberGeneratorService();
		for (int i = 0; i <= 100; i++) {
			// service.submit(new RandomNumberGeneratorService());
			service.execute(generator);
		}
		Future<Integer> future = service.submit(new RandomNumCallable());
		Integer result = future.get(); // this is a blocking operation and waits for the thread to get the result
		System.out.println("Random number is: " + result);
		// service.shutdown();

		CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
			try {
				return new RandomNumCallable().call();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}, service);
		System.out.println("First completable future result" + completableFuture.get());
		CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
			try {
				return new RandomNumCallable().call();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}, service);
		System.out.println("second completable future result" + completableFuture2.get());
		CompletableFuture<Integer> completableFuture3 = CompletableFuture.supplyAsync(() -> {
			try {
				return new RandomNumCallable().call();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}, service);
		System.out.println("third completable future result" + completableFuture3.get());
		completableFuture.thenApply(a -> {
			try {
				return a + completableFuture2.get();
			} catch (InterruptedException | ExecutionException e1) {

				e1.printStackTrace();
			}
			return a;
		}).thenApply(a -> {
			try {
				return a + completableFuture3.get();
			} catch (InterruptedException | ExecutionException e) {

				e.printStackTrace();
			}
			return a;
		}).thenAccept(System.out::println);
		service.shutdown();
		System.out.println("Execution done!!!");
		System.out.print();
	}

}
