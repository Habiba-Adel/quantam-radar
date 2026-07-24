package org.example;

public class SeatBeltRule extends Rule{

    //this is the threshold for this condition
    private boolean requiredStatus;

    public SeatBeltRule(int fees) {
        super(fees,"Seatbelt Rule");
        requiredStatus = true;
    }


    @Override
    public String getViolationMessage(CarInfo car) {
       //here we need to print just "seat not fastened and then : the fees"

        return "Seatbelt not fastned : " +getFeeText();
    }

    @Override
    public boolean isViolated(CarInfo car) {
        //here i just need to check and compare the above boolean with the carinfo boolean

        return car.isSeatBeltStatus()!= requiredStatus;
    }
}

