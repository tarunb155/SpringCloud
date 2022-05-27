package com.accenture.lkm.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIShortCircuit {

	public static void main(String[] args) {
		Stream.of("one","two","three","four").findFirst().ifPresent(System.out::println);
		Stream.of("one","two","three","four").parallel().findFirst().ifPresent(System.out::println);
		Stream.of("one","two","three","four").findAny().ifPresent(System.out::println);
		Stream.of("one","two","three","four").parallel().findAny().ifPresent(System.out::println);
		
		IntStream stream1 = IntStream.of(1,2,3,4,5,6,7);
		//boolean bool = stream1.peek(x->System.out.println(x)).anyMatch(i->i%3==0);//i->i%10==0
		//System.out.println(bool);
		//boolean bool1 = stream1.peek(x->System.out.println(x)).allMatch(i->i>0);
		//System.out.println(bool1);
		boolean bool1 = stream1.peek(x->System.out.println(x)).noneMatch(i->i>10);
		System.out.println(bool1);
	}

}
