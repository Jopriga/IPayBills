package com.jorge.project.ipaybills;

public interface PaymentsInterface {
	Payment findById(int id); 
	void add(Payment p);
	void remove(Payment p);
}
