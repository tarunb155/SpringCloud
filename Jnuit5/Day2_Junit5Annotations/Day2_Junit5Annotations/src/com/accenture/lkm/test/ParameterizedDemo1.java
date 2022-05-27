package com.accenture.lkm.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedDemo1 {
///supported for ints,longs,strings,doubles for junit 5.0
////shorts,bytes,floats,chars classes are supported for junit5.1	
@ParameterizedTest	
@ValueSource(ints= {1,2,3,4})
void intValue(int num) {
	
	System.out.println("The number is "+ num);
	assertTrue(num>0);
}

@ParameterizedTest
@ValueSource(strings= {"Car","Bus","Train"})
void stringValue(final String s) {
	System.out.println(s);
}

@ParameterizedTest
@ValueSource(doubles= {3.0,4.0,5.0})
void doubleValue(final Double d) {
	System.out.println(d);
}

//EnumSource
public enum myColors{
	PINK,GREEN,RED,BLUE
}

@ParameterizedTest
@EnumSource(myColors.class)
void simple(final myColors color) {
	assertNotNull(color);
	System.out.println(color);
	
}

@ParameterizedTest
@EnumSource(value=myColors.class,names= {"RED","BLUE"},mode = Mode.EXCLUDE)
void simpleExclude(final myColors color) {
	assertNotNull(color);
	System.out.println(color);
	
}

static List<String> myMethod(){
	List<String> list1=new ArrayList<String>();
	list1.add("LKM");
	list1.add("Junit");
	list1.add("Java");
	return list1;
}

@ParameterizedTest
@MethodSource("myMethod")
void simpleMethod(final String str) {
	assertNotNull(str);
	System.out.println(str);
}



	
	
}
