package com.accenture.lkm.fe;
@FunctionalInterface
interface Sample1{
	//exactly one abstract method
	void m1();
	//It can contain any number of default and static methods
	default void m2() {
		
	}
	default void m3() {
		
	}
	static void m4() {
		
	}
	static void m5() {
		
	}
	//It can declare methods of Object class 
	public String toString();
	public boolean equals(Object obj);
}
public class FunctionalInterfaceDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
