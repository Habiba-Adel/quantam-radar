package org.example;

public abstract class Rule {

    //now this will has the common things that all the rules childs classes will include too

    //the first thing each rule has its own fees
    private int fees ;

    public Rule(int fees){
        this.fees=fees;

    }

    public int getFees(){
        return fees;
    }

//and this to help radar to print and that why here we use the delegation
    public abstract String getViolationMessage(CarInfo car);


    //and we will need to check if this rule is violated or no
    public abstract boolean isViolated(CarInfo car);


    protected String getFeeText() {
        return getFees() + " EGP";
    }



}
