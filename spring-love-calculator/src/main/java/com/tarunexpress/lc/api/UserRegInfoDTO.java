package com.tarunexpress.lc.api;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.tarunexpress.lc.Validator.Age;

public class UserRegInfoDTO {
	@NotBlank(message = "Name cannot be null")
	@Size(min = 3, max = 15, message = "Name should have character between 3 and 15")
	private String name;
	@NotBlank(message = "UserName cannot be null")
	@Size(min = 3, max = 15, message = "UserName should have character between 3 and 15")
	private String userName;
	private String crushName;
	private char[] password;
	private String country;
	private String gender;
	@Age(lower=35, upper=65)
	private Integer age;
	private String[] hobbies;
	@AssertTrue(message="You have to agree to our terms and condition to use our app")
	private boolean termsandcondition;
	private CommunicationDTO communicationDTO;
	private CreditCardDTO creditcardDTO;
	private BigDecimal amount;
	private Currency currency;
	private Date date;
	private String result;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCrushName() {
		return crushName;
	}

	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public boolean isTermsandcondition() {
		return termsandcondition;
	}

	public void setTermsandcondition(boolean termsandcondition) {
		this.termsandcondition = termsandcondition;
	}

	public CommunicationDTO getCommunicationDTO() {
		return communicationDTO;
	}

	public void setCommunicationDTO(CommunicationDTO communicationDTO) {
		this.communicationDTO = communicationDTO;
	}
	

	public CreditCardDTO getCreditcardDTO() {
		return creditcardDTO;
	}

	public void setCreditcardDTO(CreditCardDTO creditcardDTO) {
		this.creditcardDTO = creditcardDTO;
	}
	
	

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "UserRegInfoDTO [name=" + name + ", userName=" + userName + ", crushName=" + crushName + ", password="
				+ Arrays.toString(password) + ", country=" + country + ", gender=" + gender + ", age=" + age
				+ ", hobbies=" + Arrays.toString(hobbies) + ", termsandcondition=" + termsandcondition
				+ ", communicationDTO=" + communicationDTO + ", creditcardDTO=" + creditcardDTO + ", amount=" + amount
				+ ", currency=" + currency + ", date=" + date + ", result=" + result + "]";
	}	
}
