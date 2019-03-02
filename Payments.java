package com.jorge.project.ipaybills;

import java.util.ArrayList;

public class Payments implements PaymentsInterface{
	private ArrayList<Payment>payments;
	
	public Payments(ArrayList<Payment>payments){
		this.payments = payments;
	}
	
	public void add(Payment payment){
		payments.add(payment);
		payment.getFrom().pay(payment.getMoney());
		payment.getTo().receive(payment.getMoney());
	}
	
    	public Payment find(int id){
        	return payments.get(id);
    	}
	
	public int size(){
    		return payments.size();
    	}
} 
