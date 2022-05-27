package com.accenture.lkm.fe;
@FunctionalInterface
interface Sample{
	void print();
}
public class FunctionalInterfaceDemo1 {
	public static void main(String[] args) {
		Sample sam = new Sample() {
			@Override
			public void print() {
				System.out.println("Hello World");
			}
		};
		sam.print();
	}
}
