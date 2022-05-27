package com.accenture.lkm.standardinterface;

import java.util.function.*;

public class SEDemo1 {

	public static void main(String[] args) {
		Function<Integer, Integer> function = a->a*10;//R apply(T)
		System.out.println(function.apply(10));
		Consumer<String> consumer = string->System.out.println(string.toUpperCase());//void accept(T)
		consumer.accept("hello world");
		BiConsumer<String,String> biconsumer = (string1,string2)->System.out.println(string1+string2);//void accept(T,U)
		biconsumer.accept("Hello ", "World");
		Supplier<Integer> supplier = ()->10*10;//T get()
		System.out.println(supplier.get());
		Predicate<Integer> predicate = a->a%2==0;//boolean test(t)
		System.out.println(predicate.test(11));
	}

}
