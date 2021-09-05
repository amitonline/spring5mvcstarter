package com.truelogic.spring5;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.truelogic.spring5.service.EmailsService;  
import com.truelogic.spring5.model.Emails;  

@Controller
public class AdminController {
 
	private String USERID = "admin@mailinglist.com";
	private String PWD = "leonidas";
	
	private EmailsService emailsService;

	@Autowired(required=true)
	@Qualifier(value="emailsService")
	public void setEmailsService(EmailsService es){
		this.emailsService = es;
	}
	
	@RequestMapping(value="/admin/login")
	 public String login(Model model) {
		model.addAttribute("pageTitle", "Mailing List Application - Admin Login");
		return "admin/login";
	}
	
	@RequestMapping(value="/admin/dologin", method=RequestMethod.POST)
	public String doLogin(HttpServletRequest request, HttpServletResponse response, Model model) {
	
		String userId = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		if (userId == null || pwd == null || userId.equals("") || pwd.equals("")) {
			model.addAttribute("error", "Login data is missing");
			return "admin/login";
		}
		HttpSession hSession = request.getSession(false);
		if (hSession == null) {
			 hSession = request.getSession();
		}
		
		if (userId.equals(USERID) && pwd.equals(PWD)) { 
			hSession.setAttribute("admin_id", 1);
			
			return "admin/dashboard";
		} else {
			model.addAttribute("error", "Login was invalid");
			return "admin/login";
		}
		 
	}
	

	@RequestMapping(value="/admin/dashboard", method=RequestMethod.GET)
	public String dashboard(HttpServletRequest request, HttpServletResponse response, Model model) {
	
		HttpSession hSession = request.getSession(false);
		if (hSession == null) {
			model.addAttribute("error", "Admin session is invalid or has expired.");
			return "admin/login";
		} 
		int  userId = 0;
		if (hSession.getAttribute("admin_id") != null)
			userId = (Integer) hSession.getAttribute("admin_id") ;
		if (userId == 0) {
			model.addAttribute("error", "Admin session is invalid or has expired.");
			return "admin/login";
		}
		model.addAttribute("pageTitle", "Mailing List Application - Admin Dashboard");
		return "admin/dashboard";
		 
	}
	
	@RequestMapping(value="/admin/emails", method=RequestMethod.GET)
	public String emails(HttpServletRequest request, HttpServletResponse response, Model model) {
	
		HttpSession hSession = request.getSession(false);
		if (hSession == null) {
			model.addAttribute("error", "Admin session is invalid or has expired.");
			return "admin/login";
		} 
		int  userId = 0;
		if (hSession.getAttribute("admin_id") != null)
			userId = (Integer) hSession.getAttribute("admin_id") ;
		if (userId == 0) {
			model.addAttribute("error", "Admin session is invalid ");
			return "admin/login";
		}
		model.addAttribute("pageTitle", "Mailing List Application - Browse Emails");
		String emailId = request.getParameter("xemailid");
		
		int pageSize = 5;
		int page = 1;
		if (request.getParameter("p") != null) {
			try {
				page = Integer.parseInt(request.getParameter("p"));
			} catch (Exception ex) {
				page = 1; 
			}
		}
		long count = emailsService.getCount(emailId);
		model.addAttribute("count", count);
		
		  // calculate pages
        int pages = (int) count/ pageSize;
        if ((pages * pageSize) < (int) count) 
        	pages ++;
        int startRow = (page-1) * pageSize;
        model.addAttribute("pages", pages);
        model.addAttribute("startPage", page);
        model.addAttribute("startRow", startRow+1);
        if (startRow+ pageSize <= count)
        	model.addAttribute("endRow", startRow+pageSize);
        else
        	model.addAttribute("endRow", count);
		
		model.addAttribute("pageSize", pageSize);
		
		List<Emails> lstEmails = emailsService.getEmails(emailId, startRow, pageSize);
		model.addAttribute("list", lstEmails);
		return "admin/emails";
		 
	}

	@RequestMapping(value="/admin/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("pageTitle", "Mailing List Application - Admin Login");
		HttpSession hSession = request.getSession(false);
		hSession.setAttribute("admin-id", null);
		hSession.invalidate();
		return "admin/login";
		 
	}
}
