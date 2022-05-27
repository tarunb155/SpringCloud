package com.tarunexpress.lc.controllers;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tarunexpress.lc.Service.LCAppService;
import com.tarunexpress.lc.Service.LCAppServiceImpl;
import com.tarunexpress.lc.api.CreditCardDTO;
import com.tarunexpress.lc.api.UserRegInfoDTO;
import com.tarunexpress.lc.propertyeditor.CreditCardEditor;
import com.tarunexpress.lc.propertyeditor.MyCurrencyEditor;

@SessionAttributes("userreginfo")
@Controller
public class RegistrationController {
	@Autowired
	private LCAppServiceImpl lcappService;
	
	
	@RequestMapping("/")
	public String showRegistrationPage(Model model) {
		model.addAttribute("userreginfo", new UserRegInfoDTO());
		
		
//		Phone phone = new Phone();
//		phone.setCountryCode("91");
//		phone.setUserNumber("9080706050");
//		CommunicationDTO communicationdto = new CommunicationDTO();
//		communicationdto.setPhone(phone);
//		userreginfo.setCommunicationDTO(communicationdto);
		
//		CreditCardDTO creditcardDTO = new CreditCardDTO();
//		creditcardDTO.setCreditDigit1("0987");
//		creditcardDTO.setCreditDigit2("6754");
//		creditcardDTO.setCreditDigit3("3452");
//		creditcardDTO.setCreditDigit4("0104");
//		userreginfo.setCreditcardDTO(creditcardDTO);
		
		
		return "user-registration-page";
	}

	@RequestMapping("/registrationdetails")
	public String showRegistrationSuccessPage(Model model,@Valid UserRegInfoDTO userreginfo,BindingResult result) 
	{
		model.addAttribute("userreginfo", userreginfo);
		model.addAttribute(BindingResult.MODEL_KEY_PREFIX+"userreginfo",result);
		userreginfo.isTermsandcondition();
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError temp : allErrors) {
				System.out.println(temp);
			}
			return "user-registration-page";
		}
		
		String appResult= lcappService.calculateLove(userreginfo.getUserName(),userreginfo.getCrushName());
		userreginfo.setResult(appResult);
	
		return "registration-details";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder)
	{	//editor for converting space into null values
		StringTrimmerEditor editor= new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, "name", editor);
		//editor for converting string value entered by user for date field to date type
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy");
		CustomDateEditor customDateEditor= new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class,"date",customDateEditor);
		//editor for converting amount string value to Big decimal field
		DecimalFormat decimalFormat= new DecimalFormat("##,###.00");
		CustomNumberEditor customNumberEditor=new CustomNumberEditor(BigDecimal.class, decimalFormat, true);
		binder.registerCustomEditor(BigDecimal.class, "amount",customNumberEditor);
		//editor for converting currency string value to currency type
		MyCurrencyEditor currencyEditor= new MyCurrencyEditor();
		binder.registerCustomEditor(Currency.class,"currency" ,currencyEditor);
		CreditCardEditor cardEditor= new CreditCardEditor();
		binder.registerCustomEditor(CreditCardDTO.class,"creditcardDTO" ,cardEditor);
	}
}
