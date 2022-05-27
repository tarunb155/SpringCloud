package com.accenture.lkm.streams;

import java.util.Optional;
import java.util.stream.IntStream;

public class PrimitveStreams {

	public static void main(String[] args) {
		IntStream s1 = IntStream.range(1, 5);
		s1.forEach(x->System.out.println(x));
		IntStream s2 = IntStream.rangeClosed(1, 5);
		s2.forEach(x->System.out.println(x));
		Optional<Integer> op = IntStream.rangeClosed(1, 5).boxed().filter(x->x>2).parallel().findAny();
		System.out.println(op.get());
	}

}
