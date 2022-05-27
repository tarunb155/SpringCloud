package com.accenture.lkm.streams;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.*;
public class ProductUsecases {

	public static void main(String[] args) {
		List<Product1> list = ProductUtility.getProductList();
		//Print the details of all the product
		//list.forEach(prod->System.out.println(prod));
		//Print the details of the products that starts with I
		//list.stream().filter(p->p.getName().startsWith("I")).forEach(prod->System.out.println(prod));
		//Print the details of the products that are having price greater than 20000 and producttype N
		//list.stream().filter(p->p.getPrice()>20000& p.getProductType().equals("N")).forEach(prod->System.out.println(prod));
		//Print the details pf products having the length of name less than or equal to 3
		//list.stream().filter(p->p.getName().length()<=3).forEach(prod->System.out.println(prod.getName()));
		//Sum of price
		//double sum = list.stream().map(p->p.getPrice()).collect(Collectors.summingDouble(d->d));
		//double sum = list.stream().mapToDouble(p->p.getPrice()).sum();
		//System.out.println("The sum is "+sum);
		//Find the maximum price
		//double max = list.stream().mapToDouble(p->p.getPrice()).max().orElse(0.0f);
		//System.out.println(max);
		//Map<Integer,String> map = list.stream().filter(p->p.getName().startsWith("I")).collect(Collectors.toMap(p->p.getId(), p->p.getName()));
		//System.out.println(map);
		Map<String,List<Product1>> map = list.stream().collect(Collectors.groupingBy(p->p.getProductType()));
		System.out.println(map);
		Set<Entry<String,List<Product1>>> set = map.entrySet();
		for(Entry<String,List<Product1>> s:set) {
			System.out.println(s.getKey()+"---"+s.getValue());
		}
		double max = list.stream().mapToDouble(p->p.getPrice()).max().orElse(0.0f);
		List<Product1> li = list.stream().filter(p->p.getPrice()==max).collect(Collectors.toList());
		li.stream().forEach(prod->System.out.println(prod.getName()+" "+prod.getPrice()));
		
	}

}









