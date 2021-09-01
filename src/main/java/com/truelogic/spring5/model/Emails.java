package com.truelogic.spring5.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="emails")
public class Emails {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	
	@Column(name="email")
	private String email;
	
	@Column(name="name")
	private String name;
	
	@Column(name="signup")
	private Date signup;
	
	@Column(name="vkey")
	private String vKey;
	
	@Column(name="verified")
	private int verified;
	
	public int getID() { return ID;}
	public String getEmail() { return email;}
	public String getName() { return name;}
	public Date getSignup() { return signup;}
	public String getVKey() { return vKey;}
	public int getVerified() { return verified;}
	
	public void setEmail(String v) { email = v;}
	public void setName(String v) { name = v;}
	public void setSignup(Date v) { signup = v;}
	public void setVKey(String v) { vKey = v;}
	public void setVerified(int v) { verified = v;}
	
	public  String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append(String.valueOf(ID) +"," + email + "," + name);
		return sb.toString();
	} 
	
	
}
