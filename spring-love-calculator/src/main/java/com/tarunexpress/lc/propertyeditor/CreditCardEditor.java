package com.tarunexpress.lc.propertyeditor;

import java.beans.PropertyEditorSupport;

import com.tarunexpress.lc.api.CreditCardDTO;

public class CreditCardEditor extends PropertyEditorSupport{

@Override
	public String getAsText() {
		// TODO Auto-generated method stub
	CreditCardDTO cardDTO=(CreditCardDTO)getValue();
		return "sample:"+ cardDTO;
	}
	
@Override
public void setAsText(String text) throws IllegalArgumentException {
	String[] creditCardArray = text.split("-");
	CreditCardDTO creditcardDTO = new CreditCardDTO();
	creditcardDTO.setCreditDigit1(creditCardArray[0]);
	creditcardDTO.setCreditDigit2(creditCardArray[1]);
	creditcardDTO.setCreditDigit3(creditCardArray[2]);
	creditcardDTO.setCreditDigit4(creditCardArray[3]);
	setValue(creditcardDTO);
}


	
}
