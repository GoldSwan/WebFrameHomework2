package kr.ac.hansung.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller//@Component + 컨트롤러 역할
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome(Locale locale, Model model) {//모델 만들지않아도 인자로만 주면 자동생성, 주소값넣어줌
		
		return "home";//뷰의 이름 
	}
}
