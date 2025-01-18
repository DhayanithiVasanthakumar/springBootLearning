package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class IndexControllerOldApproch {

	@RequestMapping("index")
	//creating request
	public String index(HttpServletRequest request) {
		
		//http://localhost:8080/index?name=
		//request in url -> after ?____
		//mudincha aalavuku jsp file la java code write pana matanga -> ithuku HTTP Session use panuvanga
		
		//getSession() -> parameter la irukara request oda session ah maintain aagum
		HttpSession session=request.getSession();
		String nameRequest =request.getParameter("name");
		
		/*
		 * run panum pothu 
		 * ipa url la after ?  name = dhaya nu kudutha antha "name" tha "nameRequest" la store aagum
		 * antha "nameRequest" ah yeduthu keela irukara "userName" ah attribute set pani "index.jsp" ku sent panare
		 * antha index.jsp userName ah print panum
		 */
		
		//session ta "nameRequest" ah "userName" nu attribute ah setAttribute() la solanum
		//ipa intha "userName" ah direct ah jsp ta pooitu ->'$' symbol kulla userName nu kudutha pothum
		session.setAttribute("userName", nameRequest);
		
		//***************************************
		//mela request pana tha keela return la respond panarom
		//**************************************
		
		//return is "response" another name is "view"
		//in return type, end of index to add file format like(.jsp) is bad approach ,
		//it is against the principle of MVC
		//so use application property to over come this approach
		//return "index.jsp";
		return "index";
	}
}
