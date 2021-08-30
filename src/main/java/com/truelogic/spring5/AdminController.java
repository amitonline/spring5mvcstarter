package com.truelogic.spring5;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  

@Controller

public class AdminController {
 
	@RequestMapping(value="/admin/login")
	public String login() {
		return "admin/login";
	}
}
