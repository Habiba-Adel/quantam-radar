package org.example;

import java.util.HashMap;
import java.util.Map;


//here this class needed to make the last 2 required features that related to the get all fees and the each violated rule with count
//which need to be tracked across all observations happened

public class History {

    //this will store the plate numebr,total fees and in hash table to get the information very fast in just o(1)
    private Map<String, Integer> totalFees;

    //and each rule with the count of violateion happened to this rule until now
    private Map<String, Integer> violatedRulesCount;

    public History() {
        this.totalFees = new HashMap<>();
        this.violatedRulesCount = new HashMap<>();
    }

    public void recordObservationIntoHistory(Observation observation) {
        String plate = observation.getCar().getPlateNumber();
        int fees = observation.getTotalFees();

        //cause if this plate number is new we will need to make for it or update the current fees that stored to add on it the new fees from this observation
        totalFees.put(plate, totalFees.getOrDefault(plate, 0) + fees);

        for (Rule rule : observation.getViolatedRules()) {
            String ruleName = rule.getClass().getSimpleName(); // to get the rule name cause we not save them ar rule information and there is no need for that the name is like the child class name
            violatedRulesCount.put(ruleName, violatedRulesCount.getOrDefault(ruleName, 0) + 1);
        }
    }

    public Map<String, Integer> getAllFines() {
        return totalFees;
    }

    public Map<String, Integer> getAllViolatedRulesWithCount() {
        return violatedRulesCount;
    }
}