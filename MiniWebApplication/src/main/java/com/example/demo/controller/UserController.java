package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.UserDetails;

@Controller
public class UserController {

	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("index")
	public String index() {
		return "index.jsp";
	}
	
	/*
	 * CRUD operations -> CREATE , READ , DELETE, UPDATE 
	 */
	
	//CREATE
	@RequestMapping("addUser")
	public String addUser(UserDetails  userObj) {
		
		userDAO.save(userObj);//model ooda obj ah db la store pani vaikum,-> so that's why we create pojo class .
		return "index.jsp";
	}
	//READ
	@RequestMapping("getUser")
	//UserDetails oda alla obj um theva ila athoda id mattu pothu
	public ModelAndView getUser(@RequestParam int id) {
		
		ModelAndView mav=new ModelAndView("showUser.jsp");//->VIEW
		//userDAO obj vanthu db ah connect pannu 
		//apram parameter la kudutha id ah user obj muliyam ah kontu varum 
		//munnadi itha execption ah handle panitu irunthanga, ipa  "Optional" muliyam ah handle panaranga
		//suppose db la illa tha data va keta run time exception throw pana kudathu, so
		//ithuku tha "Optional" kontu vanthanaga ->it handle null pointer exception
		UserDetails userObj=userDAO.findById(id).orElse(new UserDetails());//MODEL
		//intha userObj data va mav ta "modalObj" intha per kudukaren
		mav.addObject("modalObj", userObj);//->MODEL OBJ
		return mav;
	}
	//DELETE
	@RequestMapping("deleteUser")
	public ModelAndView deleteUser(@RequestParam int id) {
		
		ModelAndView mav=new ModelAndView("deleteUser.jsp");//->VIEW
		UserDetails userObj=userDAO.findById(id).orElse(new UserDetails());//MODEL
		userDAO.deleteById(id);
		mav.addObject("modalObj", userObj);//->MODEL OBJ
		return mav;
	}
	//UPDATE
	@RequestMapping("updateUser")
	//update pana user oda alla obj um theva so POJO class ku obj create panaren
	public ModelAndView updateUser(UserDetails userObj) {
		
		ModelAndView mav=new ModelAndView("updateUser.jsp");//->VIEW
		userObj=userDAO.findById(userObj.getId()).orElse(new UserDetails());//MODEL
		userDAO.deleteById(userObj.getId());
		mav.addObject("modalObj", userObj);//->MODEL OBJ
		return mav;
	}
}
