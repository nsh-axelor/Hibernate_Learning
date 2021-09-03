package com.nandit.demoHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Aliens_Table")
public class Aliens {
	
	
	@Column(name="Alien_ID")
	@Id
	private int aid;
	
	
	@Column(name="Alien_Color")
	private String color;
	
	@Column(name="Alien_Name")
	private Name aname;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Name getAname() {
		return aname;
	}
	public void setAname(Name aname) {
		this.aname = aname;
	}

	@Override
	public String toString() {
		return "Aliens [aid=" + aid + ", color=" + color + ", aname=" + aname + "]";
	}
	
	
}
