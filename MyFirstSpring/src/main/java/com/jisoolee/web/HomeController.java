package com.jisoolee.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		// 1. ��Ʈ�ѷ� �޼��尡 �۾��� ó��
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		// 2. �۾� ����� Model�� ����
		model.addAttribute("serverTime", formattedDate ); // views�� home.jsp ���� serverTime�ִµ�, �� ���� �ѷ��� ����.
		
		// 3. �۾� ����� ������ View�� ����
		return "home2"; // home�� /WEB_INF/view/home.jsp. view �̸��� �����ָ� ��.
	}
	
}
