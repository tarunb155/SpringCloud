package com.tarunexpress.lc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.tarunexpress.lc.api.CreditCardDTO;
import com.tarunexpress.lc.api.Phone;

public class CreditCardFormatter implements Formatter<CreditCardDTO> {

	@Override
	public String print(CreditCardDTO creditcardDTO, Locale locale) {
		System.out.println("Entering print method");
		return creditcardDTO.getCreditDigit1() + "-" + creditcardDTO.getCreditDigit2() + "-" +creditcardDTO.getCreditDigit3() + "-" +creditcardDTO.getCreditDigit4();
	}

	@Override
	public CreditCardDTO parse(String completecreditcardnumber, Locale locale) throws ParseException
	{
		System.out.println("Entering parse method");
		CreditCardDTO creditcardDTO = new CreditCardDTO();
		String[] creditCardArray = completecreditcardnumber.split("-");
		creditcardDTO.setCreditDigit1(creditCardArray[0]);
		creditcardDTO.setCreditDigit2(creditCardArray[1]);
		creditcardDTO.setCreditDigit3(creditCardArray[2]);
		creditcardDTO.setCreditDigit4(creditCardArray[3]);
		return creditcardDTO;
	}
	
}
