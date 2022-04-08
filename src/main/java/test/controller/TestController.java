package test.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import test.bean.UserBean;
import test.model.User;
import test.service.TestService;

@RestController
//@CrossOrigin(origins="http://localhost:8080",allowedHeaders = "*") 
@CrossOrigin(origins="http://localhost:3000",allowedHeaders = "*") 
@RequestMapping(value = "/api")
public class TestController {
	@Autowired
	private TestService service;
	
	UserBean userBean;

	//@RequestMapping("running")
	 @RequestMapping(value = "/running", method = RequestMethod.POST)
	public String application() {
		System.out.println("helo");
		return "App is running..........................";
	}
	  @RequestMapping(value = "/saveData", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	  public String saveData(@RequestParam("uName") String uName,@RequestParam("uEmail") String uEmail)throws ParseException{
	
		  userBean=new UserBean();
		  userBean.setuName(uName);
		  userBean.setuEmail(uEmail);
		  
		  System.out.println(userBean.getuName());
		  boolean flag=this.service.saveData(userBean);
		  System.out.println(flag);
		  if(flag==true) {
			  return  "Success";
		  }
		  return  "failed"; 
	  }
	  
	  @RequestMapping(value = "/fetchUser", method = RequestMethod.GET)
	  public List<UserBean> fetchUser(){
		  return this.service.fetchUser();
	  }
	  
	  
	  
	  @PostMapping("addUser")
	  public String addUser(@RequestBody UserBean user) {
		  boolean flag=this.service.saveData(user);
		  if(flag==true) {
			  return  "Success";
		  }
		  return  "failed"; 
	  }
}
