package com.accenture.lkm.conc;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrencyDemo1 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Runnable runnable = ()->System.out.println("Thread runs");
		ExecutorService ex = Executors.newSingleThreadExecutor();
		//ex.submit(runnable);
		//ex.shutdown();
		
		Callable<String> callable = ()->"Result of callable";
		Future<String> future = ex.submit(callable);
		//if(future.isDone())
			System.out.println(future.get());
		ex.shutdown();

		CompletableFuture<String> cf = new CompletableFuture<>();
		cf.complete("Future's result");
		System.out.println(cf.get());
		//supplyAsync
		//thenAccept
		//thenApply
		//thenApplyAsync
		//thenCombine
		//thenCombineAsync
	}

}







