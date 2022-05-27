package com.accenture.lkm.mr;

import java.util.function.BiFunction;

class Calc{
	public static int add(int a,int b) {
		return a+b;
	}
}
public class MR2 {

	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> a = Calc::add;
		System.out.println(a.apply(10, 20));
	}

}
