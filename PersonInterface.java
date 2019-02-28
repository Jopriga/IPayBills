package com.jorge.project.ipaybills;

public interface PersonInterface {
    Person findById(int id);
    Person findByName(String name);
    void add(Person p); 
    void remove(Person p);
    int size();
}
