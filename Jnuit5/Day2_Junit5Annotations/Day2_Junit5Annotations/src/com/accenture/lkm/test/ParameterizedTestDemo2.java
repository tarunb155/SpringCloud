package com.accenture.lkm.test;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class ParameterizedTestDemo2 {


@ParameterizedTest	
@CsvSource(value= {"Accenture@1","Bangalore@2","Pune@3"},delimiter = '@')
void simpleCSV(final String s1 ,final int n1) {
	System.out.println("String Value:" + s1);
	System.out.println("Number Value: "+ n1);
}
@ParameterizedTest	
@CsvFileSource(resources = "/resources/users.csv")
void SimpleCsvFile(final String emailId,final String name) {
	assertNotNull(name);
	assertNotNull(emailId);
	System.out.println("First Column "+ emailId);
	System.out.println("Second Column "+ name);
}
	
}
