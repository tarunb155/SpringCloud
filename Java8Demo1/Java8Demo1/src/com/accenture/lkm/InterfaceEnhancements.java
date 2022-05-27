package com.accenture.lkm;
interface SampleInterface{
	void m1();//must be overridden
	default void m2() {//can be overridden
		System.out.println("Default method");
	}
	static void m3() {//cannot be overridden
		System.out.println("Static method");
	}
}
class SampleInterfaceImpl implements SampleInterface{
	@Override
	public void m1() {
		System.out.println("M1");
	}
	@Override
	public void m2() {
		System.out.println("Overriding default method");
	}
}
public class InterfaceEnhancements {

	public static void main(String[] args) {
		SampleInterface object = new SampleInterfaceImpl();
		object.m1();
		object.m2();
		SampleInterface.m3();

	}

}
