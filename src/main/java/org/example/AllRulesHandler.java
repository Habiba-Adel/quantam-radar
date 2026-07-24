package org.example;

import java.util.ArrayList;
import java.util.List;


//ths one its only simple goal is to store and handle the rules definations and to add and remove rules

public class AllRulesHandler {
    //here this one for the single responsability its only goal is to store all rules and add new one or delete one

    //so we will need here to store array of all rules
    private List<Rule> rules ;

    public AllRulesHandler(){
        this.rules= new ArrayList<>();
    }


    public void addRule(Rule rule){
        rules.add(rule);
    }

    public void deleteRule(Rule rule){
        rules.remove(rule);
    }


    //and will need get all rules function to can use them in the checking if there is violation or no
    public List<Rule> getRules() {
        return rules;
    }



}
