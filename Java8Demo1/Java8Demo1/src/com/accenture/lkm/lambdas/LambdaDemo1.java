package com.accenture.lkm.lambdas;
@FunctionalInterface
interface Sample{
	int add(int a,int b);
}
public class LambdaDemo1 {
	public static void main(String[] args) {
		Sample sam = 
			(a,b)-> {
				return a+b;
			};
		System.out.println(sam.add(10, 10));	

	}
}
