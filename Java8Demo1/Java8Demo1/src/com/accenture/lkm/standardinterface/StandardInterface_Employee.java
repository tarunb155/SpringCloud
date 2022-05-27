package com.accenture.lkm.standardinterface;

import java.util.function.*;

public class StandardInterface_Employee {

	public static void main(String[] args) {
		BiConsumer<Integer, String> emp1 = (id,name)->new Employee().printDetails(id, name);
		emp1.accept(1001, "John");
		Consumer<String> emp2 = (city)->new Employee().printCity(city);
		emp2.accept("Pune");
		BiConsumer<Employee, String> emp3 = (emp,city)->emp.printCity(city);
		emp3.accept(new Employee(), "Chennai");
		Supplier<Integer> emp4 = ()->new Employee().returnSomething();
		System.out.println(emp4.get());
		Function<Employee, Integer> emp5 = (emp)->emp.returnSomething();
		int res = emp5.apply(new Employee());
		System.out.println(res);
		Function<Double,Double> emp6 = (sal)->new Employee().calcAnnSalary(sal);
		System.out.println(emp6.apply(1000.0));
	}

}
