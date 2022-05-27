package com.accenture.lkm.streams;
import java.util.stream.*;
import java.util.*;
public class StreamCreation {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("hello","welcome","hi");
		Stream<String> stream1 = words.stream();
		
		Stream<String> stream2 = Stream.of("hello","Bye");
		
		String[] words2 = {"A","B","C"};
		Stream<String> stream3 = Stream.of(words2);
		
		Integer[] nums= {1,2,3};
		Stream<Integer> st1 = Stream.of(nums);
		
		int[] no= {1,2,3};
		IntStream st2 = Arrays.stream(no);
		
		IntStream st3 = IntStream.of(no);
	}

}
