package com.accenture.lkm;
interface MathOperation1{
	int add(int num1,int num2);
}
class OperationExecutor{
	public void executor(MathOperation1 math,int num1,int num2) {
		System.out.println(math.add(num1, num2));
	}
}
public class HOFDemo {

	public static void main(String[] args) {
		MathOperation1 math = new MathOperation1() {
			@Override
			public int add(int num1, int num2) {
				return num1+num2;
			}
		};
		MathOperation1 math1 = new MathOperation1() {
			@Override
			public int add(int num1, int num2) {
				return num1+num2+100;
			}
		};
		OperationExecutor execute = new OperationExecutor();
		execute.executor(math, 10, 10);
		execute.executor(math1, 10, 10);

	}

}
