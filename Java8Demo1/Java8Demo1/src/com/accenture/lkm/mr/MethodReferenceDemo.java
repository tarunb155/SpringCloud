package com.accenture.lkm.mr;
interface S1{
	void m1();
}
public class MethodReferenceDemo {
	public MethodReferenceDemo() {
		System.out.println("Constructor");
	}
	public void m11() {
		System.out.println("Non static method");
	}
	public static void m21() {
		System.out.println("Static method");
	}
	public static void main(String[] args) {
		MethodReferenceDemo object = new MethodReferenceDemo();
		S1 s1 = object::m11;
		S1 s2 = MethodReferenceDemo::m21;
		S1 s3 = MethodReferenceDemo::new;
		s1.m1();
		s2.m1();
	}

}
