package com.jorge.project.ipaybills;

public interface PersonInterface {
	Person findById(int id);
    Person findByName(String name);
    void addPerson(Person e); //
    void removePerson(Person e);
    int size();
}
