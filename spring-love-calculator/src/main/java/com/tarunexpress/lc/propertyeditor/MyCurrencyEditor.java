package com.tarunexpress.lc.propertyeditor;

import java.beans.PropertyEditorSupport;
import java.util.Currency;



public class MyCurrencyEditor extends PropertyEditorSupport{
	
@Override
public void setAsText(String text) throws IllegalArgumentException {
	// TODO Auto-generated method stub
	Currency currency=Currency.getInstance(text.toUpperCase());
	setValue(currency);
}
	

}
