package com.accenture.lkm;
import java.util.*;
public class HOFDemo2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("One");
		list.add("Two");
		list.add("Three");
		list.add("Four");
		System.out.println("Before Sorting "+list);
		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
		Collections.sort(list,comp);//sort() is known as HOF because it takes comp(function) as an argument
		System.out.println("After Sorting "+list);
		Comparator<String> compReversed = comp.reversed();//reversed() method return Comparator reference
											//it returns a function, So reversed() is called as HOF
		Collections.sort(list,compReversed);
		System.out.println("After Sorting in reverse order "+list);
		
	}

}
