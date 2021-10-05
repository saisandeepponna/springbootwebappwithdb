package com.ansible;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="registration")
public class Registration {
	@Id
	private String name;
	private String mail;
	@Lob
	@Column(name="PASS", length=1000)
	private String pass;
	
	
	public Registration() {
	
		
	}
	public Registration(String name, String mail, String pass) {
		super();
		this.name = name;
		this.mail = mail;
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public String getMail() {
		return mail;
	}
	public String getPass() {
		return pass;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
