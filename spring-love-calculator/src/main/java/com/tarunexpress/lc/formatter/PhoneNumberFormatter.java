package com.tarunexpress.lc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.tarunexpress.lc.api.Phone;

public class PhoneNumberFormatter implements Formatter<Phone> {

	@Override
	public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {
		Phone phone = new Phone();
		String[] phoneNumberArray = completePhoneNumber.split("-");
		int index = completePhoneNumber.indexOf("-");
		if (index == -1) {
			phone.setCountryCode("91");
			phone.setUserNumber(phoneNumberArray[0]);
		}
		else if ( index==0)
		{
			phone.setCountryCode("91");
			phone.setUserNumber(phoneNumberArray[1]);
		}
		else {
			phone.setCountryCode(phoneNumberArray[0]);
			phone.setUserNumber(phoneNumberArray[1]);
		}

		return phone;

	}

	@Override
	public String print(Phone phone, Locale locale) {
		// TODO Auto-generated method stub

		return phone.getCountryCode() + "-" + phone.getUserNumber();
	}

}
