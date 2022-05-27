package com.accenture.lkm.lambdas;
interface Math1{
	int add(int a,int b);
}
interface Math2{
	int add10(int a);
}
class OpEx{
	public void executor(Math1 math,int a,int b) {
		System.out.println("The result is "+math.add(a, b));
	}
}
public class LambdaDemo2 {
	public static void main(String[] args) {
		OpEx object = new OpEx();
		//1st full form
		Math1 m1 = (int a,int b)->{
			return a+b;
		};
		object.executor(m1, 10, 20);
		//Data type inference
		Math1 m2 = (a,b)->{
			return a+b;
		};
		object.executor(m2, 10, 20);
		//Return type inference
		Math1 m3 = (a,b)->a+b;
		object.executor(m3, 10, 20);
		//Inline lambda
		object.executor((a,b)->a+b, 10, 20);
		//5th reduced form, () is optional if a method has single argument
		Math2 m4 = a->a+10;
		System.out.println(m4.add10(10));
		
		
	}

}




