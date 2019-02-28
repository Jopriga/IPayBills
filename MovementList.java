package com.jorge.project.ipaybills;

public interface MovementList {
	Movement findById(int id);
    Movement findByName(String name);
    void add(Movement m); 
    void remove(Movement m);
    int size();
}
