package com.accenture.lkm.streams;

import java.util.Optional;

public class OptionalDemo {
	public Integer sum(Optional<Integer> a,Optional<Integer> b) {
		Integer v1 = a.orElse(new Integer(0));
		Integer v2 = b.get();
		return v1+v2;
	}
	public static Optional<Integer> convertToInt(String s){
		return Optional.of(Integer.parseInt(s));
	}
	public static void main(String[] args) {
		Integer val1 = null;
		Integer val2 = new Integer(10);
		Optional<Integer> a = Optional.ofNullable(val1);
		Optional<Integer> b = Optional.of(val2);
		OptionalDemo demo = new OptionalDemo();
		System.out.println(demo.sum(a, b));
	
		System.out.println(OptionalDemo.convertToInt("10").get());

	}

}
