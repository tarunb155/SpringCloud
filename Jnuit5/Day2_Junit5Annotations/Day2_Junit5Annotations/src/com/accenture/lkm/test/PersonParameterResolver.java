package com.accenture.lkm.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Parameter;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;


public class PersonParameterResolver implements ParameterResolver {

	
//	//Custom annotation Personannotation
//			@Retention(RetentionPolicy.RUNTIME)
//			@Target(ElementType.PARAMETER)
//			public @interface Personannotation{
//			}
	
	//resolveParamater() – serves up an object of the correct type 
	@Override	
	public Object resolveParameter(ParameterContext arg0, ExtensionContext arg1) throws ParameterResolutionException {
		// TODO Auto-generated method stub
		return new Person();
	}

	//supportsParameter()-return true if the parameter type is supported
	@Override
	public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext arg1) throws ParameterResolutionException {
		// TODO Auto-generated method stub
		return parameterContext.getParameter().getType()==Person.class;
	}
	
	
//	public Object getPersonValue(Parameter parameter,ExtensionContext arg1) {
//		//business logic what annotation is going to for you
//	}

}
