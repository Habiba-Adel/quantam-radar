package org.example;

import java.util.ArrayList;

public class Observation {

  //now when the radar check the info will make oversvation with the car info and array of its violated rules which will help the radar later to get and calculate for it the total fees and this things
    private CarInfo car;
    private ArrayList<Rule> violatedRules;

    public Observation(CarInfo car,ArrayList<Rule> violatedRules) {
        this.car=car;
        this.violatedRules=violatedRules;
    }

    //and we will need function that return


    // return total fees for all this violated rules without need for taking the plate number as parameter
    public int getTotalFees() {

        //here we will need to iterate over all this violated rules and sum and then return in the end
        int totalFees=0;

        for (Rule rule:violatedRules){
            totalFees+=rule.getFees();
        }

        return totalFees;
    }

    public CarInfo getCar() {
        return car;
    }



    // return the list of violated rules to then can for each rule of them print its message details by the radar
    public ArrayList<Rule> getViolatedRules() {
      return violatedRules;
    }


    //lets making the display ovservation method that we will call it in the radar after checking and find that there is violated rules
    public void display(){

        //first we will need to print the car info plate number
        System.out.println("Traffic fine for car " + car.getPlateNumber());

        //sedonf we will need to print the total fees by using the previous defined function we already declared
        System.out.println("Total amount: "+getTotalFees() +" EGP");

        //third we will need to iterate over each violarted rule and call its delegated method we made to show its message based on the type of the rule
        System.out.println("Violations:");
        for (Rule rule : violatedRules){
            System.out.println(rule.getViolationMessage(car));
        }




    }

}
