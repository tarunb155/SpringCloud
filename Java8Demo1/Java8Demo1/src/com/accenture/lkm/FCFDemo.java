package com.accenture.lkm;
interface MathOperation{
	int add(int num1,int num2);
}
public class FCFDemo {

	public static void main(String[] args) {
		MathOperation math = new MathOperation() {
			@Override
			public int add(int num1, int num2) {
				return num1+num2;
			}
		};
		System.out.println(math.add(10, 20));
	}

}
