package com.truelogic.spring5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.truelogic.spring5.model.Emails;
import com.truelogic.spring5.service.EmailsService;

@Controller  
public class MainController {
	private EmailsService emailsService;
	
	@Autowired(required=true)
	@Qualifier(value="emailsService")
	public void setEmailsService(EmailsService es){
		this.emailsService = es;
	}
	
	@RequestMapping("/")
	public String home(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		model.addAttribute("pageTitle", "Mailing List Application - Home");
		return "index";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	@RequestMapping(value= "/cookie-ok", method = RequestMethod.GET)
	public void cookiOk
	(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, JSONException	
	{
		JSONObject output = new JSONObject();
		PrintWriter out = response.getWriter();
		response.setContentType("text/JSON");
		HttpSession hSession = request.getSession(false);

		String rootDir = request.getSession().getServletContext().getRealPath("/");
		
		try {
			hSession.setAttribute("cookie-ok", 1);
			output.put("result", "SUCCESS");
			output.put("message", "");

		} catch (Exception e) {
			  output.put("result", "ERROR");
			  output.put("message", e.getMessage());

		}
		out.println(output.toString());
		out.close();		
	}
	

	@RequestMapping(value= "/add-email", method = RequestMethod.POST)
	public void addEmail
	(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, JSONException	
	{
		JSONObject output = new JSONObject();
		PrintWriter out = response.getWriter();
		response.setContentType("text/JSON");
		HttpSession hSession = request.getSession(false);

		String rootDir = request.getSession().getServletContext().getRealPath("/");
	
		try {
			String email = request.getParameter("email");
			if (email == null || email.equals("")) {
				output.put("result", "ERROR");
			    output.put("message", "Email id is missing!"); 
			} else {
			
					// validate for duplicate
					Emails em = emailsService.getRowByEmailId(email);
					String email1 = "";
					
					if (em != null) {
						email1 = em.getEmail().toLowerCase();
					}
					
					String email2 = email.toLowerCase();
					
					if (em != null && email1.equals(email2)) { 
						  output.put("result", "ERROR");
						  output.put("message", "Email id already exists!");
					} else {
						// generate verification code
						String vkey = ""+((int)(Math.random()*900000)+100000);
						
						Emails e = new Emails();
						e.setEmail(email);
						e.setSignup(Calendar.getInstance().getTime());
						e.setName("");
						e.setVKey(vkey);
						this.emailsService.addEmail(e);  
						
						output.put("result", "SUCCESS");
						output.put("message", "");
					}
			
			}

		} catch (Exception e) {
			  output.put("result", "ERROR");
			  output.put("message", e.getMessage());

		}
		out.println(output.toString());
		out.close();		
	}
}
