package com.tarunexpress.lc.controllers;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tarunexpress.lc.Service.LCAppEmailServiceImpl;
import com.tarunexpress.lc.api.EmailDTO;
import com.tarunexpress.lc.api.UserRegInfoDTO;

@Controller
public class EmailController {
	Logger logger =Logger.getLogger(EmailController.class.getName());
	@Autowired
	private LCAppEmailServiceImpl lcAppEmailService;
//	@ModelAttribute("emailDTO") EmailDTO emailDTO
	@RequestMapping("/sendEmail")
	public String sendEmail(Model model) {
		model.addAttribute("emailDTO", new EmailDTO());	
		return "send-email-page";
	}

	@RequestMapping("/process-email")
	public String processEmail(@SessionAttribute("userreginfo") UserRegInfoDTO userreginfo,@ModelAttribute("emailDTO") EmailDTO emailDTO) {
		try
		{
		lcAppEmailService.sendEmail(userreginfo.getUserName(),emailDTO.getUserEmail(),userreginfo.getResult());
		}
		catch(Exception e)
		{
			logger.info("logging exception while sending exception"+e);
		}
		return "process-email-page";
	}

}
