package com.jorge.project.ipaybills;

public class Person {

	private String name;
	private float paid;
	
	public Person(String name){
		this.setName(name);
		this.setPaid(0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPaid() {
		return paid;
	}

	public void setPaid(float paid) {
		this.paid = paid;
	}
}
