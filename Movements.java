package com.jorge.project.ipaybills;

import java.util.ArrayList;

public class Movements implements MovementList {
	private ArrayList<Movement>movements;
	
	public Movements(ArrayList<Movement>movements){
		this.movements = movements;
	}
	
	public void add(Movement movement){
		this.movements.add(movement);
		movement.getPerson().pay(movement.getMoney());
	}
	
	public void remove(Movement movement){
		this.movements.remove(movement);
		movement.getPerson().receive(movement.getMoney());
	}

	public Movement findByName(String name){
        int aux = 0;
        for (int i=0; i<movements.size(); i++){
            if(name.equals(movements.get(i).getName())){
                aux = i;
            }
        }
        return findById(aux);
    }

    public Movement findById(int id){
        return movements.get(id);
    }

    public int size(){
        return movements.size();
    }
}
