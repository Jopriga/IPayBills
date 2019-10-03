package com.jorge.project.ipaybills.api;

import android.content.Context;

/**
 * This class defines the actions performed by an event. That includes managing people, money
 * movements, payments and its operations.
 * @author Jopriga
 * @version 24/03/2019
 * @see com.jorge.project.ipaybills.EventActivity
 *
 */
public class Event {

    // Event attributes
    private String name;
    private PeopleList people;
    private MovementList movements;
    private PaymentList payments;

    /**
     * Event constructor
     * @param name String that identifies an event
     * @param people Array with Person objects belonging to an event
     * @param movements Array with Movement objects belonging to an event
     * @param payments Array with Payment objects belonging to an event
     */
    public Event(String name, PeopleList people, MovementList movements, PaymentList payments) {
        this.name = name;
        this.setPeople(people);
        this.setMovements(movements);
        this.setPayments(payments);
    } // Constructor close

    /**
     * Method that creates a new Person object and adds it to the people ArrayList
     * @param name String with the name of the person to add to the event
     */
    public void addPerson(String name) {
        Person person = new Person(name);
        people.add(person);
    }

    /**
     * Method that removes a Person object and removes it from the people ArrayList
     * @param name String with the name of the person to remove to the event
     */
    public void removePerson(String name) {
        people.remove(people.findByName(name));
    }

    /**
     * Method that creates a new Movement object and adds it to the movements ArrayList
     * @param name String containing the name of the movement to add to the event
     * @param money Quantity associated to the movement
     * @param person String containing the person that makes the movement
     */
    public void addMovement(String name, float money, String person) {
        Movement movement = new Movement(name, money, people.findByName(person));
        movements.add(movement);
    }

    /**
     * Method that removes a Movement object and removes it from the movements ArrayList
     * @param name String with the name of the movement to remove to the event
     */
    public void removeMovement(String name) {
        movements.remove(movements.findByName(name));
    }

    /**
     * Method that creates a new Payments object and adds it to the payments ArrayList
     * @param money Quantity associated to the payment
     * @param from Person object that represent the person that makes a payment
     * @param to Person object that represents the person that receives a payment
     */
    public void addPayment(float money, Person from, Person to) {
        Payment payment = new Payment(money, from, to);
        payments.add(payment);
    }

    /**
     * Method that calculates de amount of money that everyone must have once the event is finished
     * @return Mean value of money
     */
    private float getMean() {
        float mean = 0;
        for (int i = 0; i < people.size(); i++) {
            mean += people.findById(i).getPaid();
        }
        return mean / people.size();
    }

    /**
     * Method that adds the payments to the event with the right people and money
     */
    public void settleUp() {

        float mean = this.getMean();
        float dif = 0; // Difference to pay

        for (int i = 0; i < people.size(); i++) {
            if (people.findById(i).getPaid() < mean) { // Find a person that must pay
                for (int j = 0; j < people.size(); j++) { // Search a person to receive
                    dif = mean - people.findById(i).getPaid(); // Calculate the total money to receive
                    /* The person that must pay cant´t be the same one that receives y tampoco una
                     * person that is with correct mean money
                     */
                    if (people.findById(j).getPaid() > mean && people.findById(i) != people.findById(j) &&
                            people.findById(i).getPaid() != mean) {
                        /* Calculate payment depending on the lo que le corresponda
                         * al que recibe, porque puede que con poco que reciba, salde sus deudas
                         */
                        if (dif >= (people.findById(j).getPaid() - mean)) {
                            this.addPayment(people.findById(j).getPaid() - mean,
                                    people.findById(i), people.findById(j)); // Partial payment
                        } else {
                            this.addPayment(dif, people.findById(i), people.findById(j)); // Total
                        }
                    }
                }
            }
        }
    }

    /**
     * Getter of event name attribute
     * @return String that identifies an event
     */
    public String getName() {
        return name;
    }

    /**
     * Setter of event name attribute
     * @param name String that identifies an event
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter of people attribute
     * @return Array with Person objects belonging to an event
     */
    public PeopleList getPeople() {
        return this.people;
    }

    /**
     * Setter of people attribute
     * @param people Array with Person objects belonging to an event
     */
    public void setPeople(PeopleList people) {
        this.people = people;
    }

    /**
     * Getter of movement attribute
     * @return Array with Movement objects belonging to an event
     */
    public MovementList getMovements() {
        return this.movements;
    }

    /**
     *  Setter of movements attribute
     * @param movements Array with Movement objects belonging to an event
     */
    public void setMovements(MovementList movements) {
        this.movements = movements;
    }

    /**
     * Getter of payments attribute
      * @return Array with Payment objects belonging to an event
     */
    public PaymentList getPayments() {
        return this.payments;
    }

    /**
     * Setter of payments attribute
     * @param payments Array with Payment objects belonging to an event
     */
    public void setPayments(PaymentList payments) {
        this.payments = payments;
    }

    /**
     * Method that convert a ArrayList<Person> into a String array to set the spinner adapter
     * @return String array with the names of the people
     */
    public String[]toStringPeopleList(){

        String[]peopleList = new String[people.size()];
        for(int i=0; i<people.size();i++){
            peopleList[i] = people.findById(i).getName();
        }
        return peopleList;
    }

    /**
     * Method that convert a ArrayList<Movement> into a String array to set the spinner adapter
     * @return String array with the names of the movements
     */
    public String[]toStringMovementList(){

        String[]movementList = new String[movements.size()];
        for(int i=0; i<movements.size();i++){
            movementList[i] = movements.findById(i).getName();
        }
        return movementList;
    }

    /**
     * toString() class method
     * @return String with all attributes of the event
     */
    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", people=" + people +
                ", movements=" + movements +
                ", payments=" + payments +
                '}';
    }
}
