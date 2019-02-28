package com.jorge.project.ipaybills;

public class Movement {
	
	private String name;
	private float money;
	private Person person;
	
	public Movement(String name, float money, Person person){
		this.setName(name);
		this.setMoney(money);
		this.setPerson(person);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
		
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Movement [name=" + name + ", money=" + money + ", person="+ person + "]";
	}
}
