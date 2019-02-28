package com.jorge.project.ipaybills;

public class Payment {
	
	private float money;
	private Person from;
	private Person to;
	
	public Payment(float money, Person from, Person to){
		this.setMoney(money);
		this.setFrom(from);
		this.setTo(to);
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public Person getFrom() {
		return from;
	}

	public void setFrom(Person from) {
		this.from = from;
	}

	public Person getTo() {
		return to;
	}

	public void setTo(Person to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "Payment [money=" + money + ", from=" + from + ", to=" + to + "]";
	}
}
