package com.accenture.lkm.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AssertionExample2 {

	
	String array1[] = { "bus", "car", "bike" };
	String array2[] = { "bus", "car", "bik" };
	String array3[] = { "car", "bus", "bike" };
	
	@Test
	void testArrays() {


		// asserts equality of two arrays
		//assertArrayEquals(array1, array2);
		//assertArrayEquals(array1, array2, "arrays are not equal");
		//assertArrayEquals(array1, array2, () -> "arrays are not equal");
		
		
	}
	
	@Test
	void testCollections() {
		
		Iterable <Integer> list1=new ArrayList<>(Arrays.asList(1,2,3,4));
		Iterable <Integer> list2=new ArrayList<>(Arrays.asList(1,2,3,4));
		Iterable <Integer> list3=new ArrayList<>(Arrays.asList(1,2,3));
		Iterable <Integer> list4=new ArrayList<>(Arrays.asList(1,2,4,3));
		// asserts that expected and actual iterables are deeply equal.
		// Deeply equal means that number,order of elements in collection must be same
				// and iterated elements must be equal.
				// Test will pass
		//assertIterableEquals(list1, list2);
		//assertIterableEquals(list1, list3,"List are not equal");
		//assertIterableEquals(list1, list4);
		
		List <String> expected=new ArrayList<>(Arrays.asList("Java","14","Junit5"));
		
		List <String> actual=new ArrayList<>(Arrays.asList("Java","11","Junit5"));
		
	//	assertLinesMatch(expected, actual);
		
		
	}
}
