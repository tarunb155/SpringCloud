package com.accenture.lkm;
interface Sample{
	void print(String name);
	int add(int a,int b);
}
public class AnonymousClassDemo {
	public static void main(String[] args) {
		Sample sam = new Sample() {
			@Override
			public void print(String name) {
				System.out.println("Welcome "+name);
			}

			@Override
			public int add(int a, int b) {
				return a+b;
			}
		};
		sam.print("Jai");
		System.out.println("The addition is "+sam.add(10, 20));
	}

}
