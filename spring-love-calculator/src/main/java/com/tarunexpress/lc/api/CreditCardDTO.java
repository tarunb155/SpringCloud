package com.tarunexpress.lc.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreditCardDTO {
private String creditDigit1;
private String creditDigit2;
private String creditDigit3;
private String creditDigit4;
public String getCreditDigit1() {
	return creditDigit1;
}
@NotBlank(message = "Card number cannot be null")
@Size(min = 16, message = "Credit card should have 16 digit")
public void setCreditDigit1(String creditDigit1) {
	this.creditDigit1 = creditDigit1;
}
public String getCreditDigit2() {
	return creditDigit2;
}
public void setCreditDigit2(String creditDigit2) {
	this.creditDigit2 = creditDigit2;
}
public String getCreditDigit3() {
	return creditDigit3;
}
public void setCreditDigit3(String creditDigit3) {
	this.creditDigit3 = creditDigit3;
}
public String getCreditDigit4() {
	return creditDigit4;
}
public void setCreditDigit4(String creditDigit4) {
	this.creditDigit4 = creditDigit4;
}
@Override
public String toString() {
	return getCreditDigit1()+"-"+getCreditDigit2()+"-"+getCreditDigit3()+"-"+getCreditDigit4();
}


}
