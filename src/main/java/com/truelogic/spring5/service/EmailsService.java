package com.truelogic.spring5.service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.truelogic.spring5.dao.EmailsDAO;
import com.truelogic.spring5.model.Emails;


@Service("emailsService")

public class EmailsService {

	private EmailsDAO emailsDAO;
	
	public void setEmailsDAO(EmailsDAO dao) { emailsDAO = dao;}
	
	@Transactional
	public int addEmail(Emails e) {
		return emailsDAO.addEmail(e);
	}
	
	@Transactional
	public void updateEmail(Emails e) {
		emailsDAO.updateEmail(e);
	}
	
	@Transactional
	public void deleteEmail(Emails e) {
		 emailsDAO.deleteEmail(e);
	}
	
	@Transactional
	public long getCount(String emails) {
		return emailsDAO.getCount(emails);
	}
	
	@Transactional
	public List<Emails> getEmails(String emailId, int firstRow, int maxRows) {
		return emailsDAO.getEmails(emailId, firstRow, maxRows);
	}
	
	@Transactional
	public Emails getRowByEmailId(String emailId) {
		return emailsDAO.getRowByEmailId(emailId);
	}
	
	@Transactional
	public Emails getRowByVerifyCode(String vcode) {
		return emailsDAO.getRowByVerifyCode(vcode);
	}
}
