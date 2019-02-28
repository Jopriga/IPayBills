package com.jorge.project.ipaybills;
import java.util.ArrayList;

public class People implements PersonInterface {
	private ArrayList<Person>people;
	
	public People(ArrayList<Person>people){
		this.people = people;
	}
	
	public void add(Person person){
		this.people.add(person);
	}
	
	public void removePerson(Person person){
		this.people.remove(person);
	}

	public Person findByName(String name){
        int aux = 0;
        for (int i=0; i<people.size(); i++){
            if(name.equals(people.get(i).getName())){
                aux = i;
            }
        }
        return findById(aux);
    }

    public Person findById(int id){
        return people.get(id);
    }

    public int size(){
        return people.size();
    }
}
