package com.accenture.lkm.streams;
import java.util.*;
import java.util.stream.Collectors;
public class GroupingDemo2 {

	public static void main(String[] args) {
		Student student1 = new Student(1001, "Jack",  Arrays.asList("Sub1","Sub3"));
		Student student2 = new Student(1002, "Amy",   Arrays.asList("Sub2","Sub4"));
		Student student3 = new Student(1003, "Jason", Arrays.asList("Sub5","Sub7"));
		Student student4 = new Student(1004, "Tim",   Arrays.asList("Sub6","Sub8"));
		Student student5 = new Student(1005, "Stuart",   Arrays.asList("Sub2","Sub4"));
		Student student6 = new Student(1006, "Mike", Arrays.asList("Sub5","Sub3"));
		Student student7 = new Student(1007, "Dan",   Arrays.asList("Sub4","Sub5"));
		List<Student> list  = Arrays.asList(student1,student2,student3,student4,student6,student5,student7);
		//Group the students based on list of subjects 1-odd,2-even,3-mixed
		Map<Integer,List<Student>> map=list.stream().collect(Collectors.groupingBy(x->groupFunc(x.getSubject())));
		map.forEach((x,y)->{
			System.out.println(x);
			y.forEach(st->System.out.println(st.getStudentName()));
		});
	}
	public static Integer groupFunc(List<String> i) {
		int res = 0;
		List<Integer> subId = i.stream().map(x->Integer.parseInt(x.replace("Sub", ""))).collect(Collectors.toList());
		long count = subId.stream().filter(x->x%2==0).count();
		if(count==0)
			res=1;
		else if(count==subId.size()) {
			res=2;
		}
		else 
			res = 3;
		return res;
	}
	
}
