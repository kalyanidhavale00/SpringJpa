package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
	
	@Id
	@GeneratedValue
	private int lid;
	private String lname;
	private String company;
	
	@ManyToOne
	@JoinColumn(name="jid")
	Coder coder;
	
	public Coder getCoder() {
		return coder;
	}
	public void setCoder(Coder coder) {
		this.coder = coder;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", lname=" + lname + ", company=" + company + ", coder=" + coder + "]";
	}
	
	

}
