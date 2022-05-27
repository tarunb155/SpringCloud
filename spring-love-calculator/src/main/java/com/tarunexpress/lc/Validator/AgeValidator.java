package com.tarunexpress.lc.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {

	private int lower;
	private int upper;

	@Override
	public void initialize(Age age) {
		// TODO Auto-generated method stub
		this.lower = age.lower();
		this.upper = age.upper();
	}

	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		// here i will write my main logic
		if (age < lower || age > upper || age==null) {
			return false;
		} else {
			return true;
		}
	}
}
