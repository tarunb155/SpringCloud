package com.accenture.lkm.streams;
import java.util.*;
import java.util.stream.*;
public class GroupingDemo3 {

	public static void main(String[] args) {
		List<Product1> list = ProductUtility.getProductList();
		//Group the products with respect to product type and compute the average price in each category
		Map<String,Double> map = list.stream().collect(Collectors.groupingBy(x->x.getProductType(),
								Collectors.averagingDouble(x->((Product1)x).getPrice())));
		System.out.println(map);
		//Group the products with respect to product type and count the products in each category
		Map<String,Long> map1 = list.stream().collect(Collectors.groupingBy(x->x.getProductType(),
				Collectors.counting()));
		System.out.println(map1);
		//Group the products with respect to product type and compute the sum price in each category
		Map<String,Double> map2 = list.stream().collect(Collectors.groupingBy(x->x.getProductType(),
										Collectors.summingDouble(x->((Product1)x).getPrice())));
		System.out.println(map2);
		//To fetch all the details
		Map<String,DoubleSummaryStatistics> map3 = list.stream().collect(Collectors.groupingBy(x->x.getProductType(),
				Collectors.summarizingDouble(x->((Product1)x).getPrice())));
		System.out.println(map3);
		//Group the products with respect to product type and return the details
		Map<String,Set<Product1>> set = list.stream().collect(Collectors.groupingBy(x->x.getProductType(),Collectors.toSet()));
		System.out.println(set);

	}

}







