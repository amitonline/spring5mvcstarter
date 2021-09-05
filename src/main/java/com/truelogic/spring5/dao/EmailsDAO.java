package com.truelogic.spring5.dao;


import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.truelogic.spring5.model.Emails;

@Repository
public class EmailsDAO {

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		sessionFactory = sf;
	}
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public int addEmail(Emails e) {
		Session session = sessionFactory.getCurrentSession();
		int retVal = (int) session.save(e);
		return retVal;
	}
	
	@Transactional
	public void updateEmail(Emails e) {
		Session session = sessionFactory.getCurrentSession();
		session.update(e);
	
	}
	
	public void deleteEmail(Emails e) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(e);
	
	}
	
	@SuppressWarnings({ "deprecation" })
	public long getCount(String emailId) {
		long  retVal = 0;
		Session session = sessionFactory.getCurrentSession();
		String sql = "select count(*) as total from Emails e where e.ID > 0";
		if (emailId != null && !emailId.equals(""))
			sql += " and email like :email";
		Query query = session.createQuery(sql);
		if (emailId != null && !emailId.equals(""))
			query.setParameter("email", emailId);
		retVal = (long) query.uniqueResult();
		
		
		return retVal;
	}
	
	@SuppressWarnings({"deprecation"})
	public List<Emails> getEmails(String emailId, int firstRow, int maxRows) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Emails e where e.ID > 0";
		if (emailId != null && !emailId.equals(""))
			sql += " and email like :email";
		sql += " order by email";
		Query query = session.createQuery(sql);
		if (emailId != null && !emailId.equals(""))
			query.setParameter("email", "%" + emailId + "%");
		query.setFirstResult(firstRow);
		query.setMaxResults(maxRows);
		
		List<Emails> lstEmails = query.list();
		
		return lstEmails;
	}
	
	@SuppressWarnings({"deprecation"})
	public Emails getRowByEmailId(String emailId) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Emails e where e.email = :email";
		Query query = session.createQuery(sql);
		query.setParameter("email", emailId);
		
		List<Emails> lstEmails = query.list();
		if (lstEmails.size() > 0)
			return lstEmails.get(0);
		else
			return null;
		
	}
	
	@SuppressWarnings({"deprecation"})
	public Emails getRowByVerifyCode(String vcode) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Emails e where e.vKey = :vkey";
		Query query = session.createQuery(sql);
		query.setParameter("vkey", vcode);
		
		List<Emails> lstEmails = query.list();
		if (lstEmails.size() > 0)
			return lstEmails.get(0);
		else
			return null;
		
	}
	
	
}
