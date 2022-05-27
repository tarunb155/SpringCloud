package com.accenture.lkm.streams;
import java.util.*;
import java.util.stream.Collectors;
public class GroupingDemo1 {

	public static void main(String[] args) {
		Student student1 = new Student(1001, "Jack",  Arrays.asList("Sub1","Sub2"));
		Student student2 = new Student(1002, "Amy",   Arrays.asList("Sub3","Sub4"));
		Student student3 = new Student(1003, "Jason", Arrays.asList("Sub5","Sub6"));
		Student student4 = new Student(1004, "Tim",   Arrays.asList("Sub7","Sub8"));
		Student student5 = new Student(1005, "Stuart",   Arrays.asList("Sub3","Sub4"));
		Student student6 = new Student(1006, "Mike", Arrays.asList("Sub5","Sub6"));
		Student student7 = new Student(1007, "Dan",   Arrays.asList("Sub7","Sub8"));
		List<Student> list  = Arrays.asList(student1,student2,student3,student4,student6,student5,student7);
		//Group the students based on studid(even,odd) 
		Map<String,List<Student>> map = list.stream().collect(Collectors.groupingBy(stud->groupFunc(stud.getStudentId())));
		System.out.println(map);
		//Group the students based on 1-odd,2-even
		Map<Integer,List<Student>> map1 = list.stream().collect(Collectors.groupingBy(stud->groupFunc2(stud.getStudentId())));
		System.out.println(map1);

	}
	public static String groupFunc(Integer i) {
		return i%2==0?"Even":"Odd";
	}
	public static Integer groupFunc2(Integer i) {
		Integer res = 1;
		if(i%2==0)
			res=2;
		return res;
	}

}
