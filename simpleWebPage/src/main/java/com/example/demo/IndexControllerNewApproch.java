package com.example.demo;

import java.net.http.HttpRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexControllerNewApproch {// CONTROLLER

	@RequestMapping("hello")
	// ithu tha "Model" la irunthu vara DATA
	// "name" -> url la irukara variable name ->anga kudukara name tha inga podanum
	// intha name ipa "HttpSession" la iruku

	// anga kudukara variable ah tha inga kudukanum nu illa ,
	// anga kudukara name ah inga @RequestParam("___") ulla kuduthu namaku
	// convenient ah irukara name ah kuduthukalam
	// namba kudukara name ku aana input @RequestParam("___") -> ithu la irunthu
	// varuthu

	// ipo @RequestParam("name"), ithe maari naraya iruntha yena oanaum na POJO
	// class create panidanum ->anthoda obj ah pass panau
	// public String index(@RequestParam("name")String inputName,HttpSession
	// session) {

	public ModelAndView index(UserDetails ud) {

		ModelAndView mav = new ModelAndView();
		// ud oda obj ah "details" la vangi atha "index" file ku sent panare
		mav.addObject("details", ud);
		mav.setViewName("helloworld");

		// straight ah intha session la DATA va "userName" nu attribute la set panidaren
		// session.setAttribute("userName", inputName);//MODEL

		return mav;// VIEW PAGE
	}
}
