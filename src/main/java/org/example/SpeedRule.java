package org.example;

public class SpeedRule extends Rule {

    private CarType type;
    private int maxSpeed;


    public SpeedRule(int fees,CarType type,int maxSpeed) {
        super(fees ,type + " Speed Limit");
        this.type=type;
        this.maxSpeed=maxSpeed;
    }

    @Override
    public String getViolationMessage(CarInfo car) {
        return "speed of " + car.getSpeed()
                + " exceeded max allowed "
                + maxSpeed
                + " : "
                + getFeeText();
    }

    @Override
    public boolean isViolated(CarInfo car) {

        //this is very much easier than just making if else chains
        return car.getCarType() == type &&
                car.getSpeed() > maxSpeed;
    }


    //here if we write messy code with tradational way so we will need to make if conditions based on the car types
    //which is bad and wrong so here we will not solving it like that we will just taking the type of the car and compared it here with the one we already saved with its speed in this class
    //if both of them not matched so that means clear violation

}
