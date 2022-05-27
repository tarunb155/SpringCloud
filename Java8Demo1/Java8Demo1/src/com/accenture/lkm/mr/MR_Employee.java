package com.accenture.lkm.mr;
import java.util.function.*;

import com.accenture.lkm.standardinterface.Employee;
public class MR_Employee {
	public static void main(String[] ar) {
		//BiConsumer<Integer, String> emp1 = (id,name)->new Employee().printDetails(id, name);
		BiConsumer<Integer, String> emp1 = new Employee()::printDetails;
		emp1.accept(1001, "John");
		//Consumer<String> emp2 = (city)->new Employee().printCity(city);
		Consumer<String> emp2 = new Employee()::printCity;
		emp2.accept("Pune");
		//BiConsumer<Employee, String> emp3 = (emp,city)->emp.printCity(city);
		BiConsumer<Employee, String> emp3 = Employee::printCity;
		emp3.accept(new Employee(), "Chennai");
		//Supplier<Integer> emp4 = ()->new Employee().returnSomething();
		Supplier<Integer> emp4 = new Employee()::returnSomething;
		System.out.println(emp4.get());
		//Function<Employee, Integer> emp5 = (emp)->emp.returnSomething();
		Function<Employee, Integer> emp5 = Employee::returnSomething;
		int res = emp5.apply(new Employee());
		System.out.println(res);
		//Function<Double,Double> emp6 = (sal)->new Employee().calcAnnSalary(sal);
		Function<Double,Double> emp6 = new Employee()::calcAnnSalary;
		System.out.println(emp6.apply(1000.0));
	}
}
