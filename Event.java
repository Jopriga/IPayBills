package com.jorge.project.ipaybills;

public class Event {
    private String name;
    private int maxPeople;
    private People people;
    private Movements movements; 
    private Payments payments;

    public Event(String name, int maxPeople, People people, Movements movements. Payments payments){
        this.name = name;
        this.maxPeople = maxPeople;
        this.setPeople(people);
    }
	
    public void addPerson(String name){
    	Person person = new Person(name);
    	people.add(person);
    }
    
    public void removePerson(String name){
    	people.remove(people.findByName(name));
    }
	
    public void addMovement(String name, float money, String person){
        Movement movement = new Movement(name,money,people.findByName(person));
    	movements.add(movement);
    }
    
    public void removeMovement(String name){
    	movements.remove(movements.findByName(name));
    }
    
    public void addPayment(float money, Person from, Person to){
    	Payment payment = new Payment(money,from,to);
    	payments.add(payment);
    }
    
    private float getMean(){
    	float allMoney = 0;
    	for(int i=0;i<people.size();i++){
    		allMoney +=people.findById(i).getPaid();
    	}
    	return allMoney/people.size();
    }
    public void settleUp(){
    	
    	float mean = this.getMean();
    	float dif = 0; // Difference to pay
    	
    	for(int i=0; i<people.size();i++){
    		
    		if(people.findById(i).getPaid()<mean){ // Find person that must pay
    			for(int j=0; j<people.size();j++){ // Search a person to receive
    				dif = mean - people.findById(i).getPaid(); // Calculate the total to pay
    				/* The person that must pay cant´t be the same one that receives y tampoco una  
    				 * person that is with correct mean money
    				 */
    				if(people.findById(j).getPaid()>mean && people.findById(i)!=people.findById(j) &&
    						people.findById(i).getPaid()!=mean){
    					/* Calculate payment depending on the zzdxdzxdzdzxjoder lo que le corresponda
    					 *  al que recibe, porque puede que con poco que reciba, salde sus deudas.xzzx
    					 */
    					if(dif>=(people.findById(j).getPaid()-mean)){ 
    						this.addPayment(people.findById(j).getPaid()-mean, people.findById(i), people.findById(j)); // Partial payment
    					}
    					else{
    						this.addPayment(dif,people.findById(i),people.findById(j)); // Total payment
    					}
    				}
    			}
    		}
    	}
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }
    
    public People getPeople() {
	return people;
    }

    public void setPeople(People people) {
	this.people = people;
    }
    
    public Movements getMovements() {
	return movements;
    }

    public void setMovements(Movements movements) {
	this.movements = movements;
    }
	
    public Payments getPayments(){
	return this.payments;
    }
	
    public void setPayments(Payments payments){
	this.payments = payments;
    }
	
    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", maxPeople=" + maxPeople +
                '}';
    }
}
