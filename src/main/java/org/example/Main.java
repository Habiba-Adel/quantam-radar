package org.example;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;



public class Main {
    public static void main(String[] args) {


        System.out.println();
        System.out.println();

        //first lets define the rules of the system
        List<Rule> rules = new ArrayList<>();
        rules.add(new SpeedRule(300, CarType.TRUCK, 60));
        rules.add(new SpeedRule(300, CarType.PRIVATE, 80));
        rules.add(new SeatBeltRule(100));

        //then lets define the radar
        Radar radar = new Radar("Radar1", "eltarek elgeded");

        //now lets define car 1 and checking if it is violated rules or no
        CarInfo car1 = new CarInfo("ABC1234", new Date(), CarType.PRIVATE, 94, true);
        checkAndPrint(radar, car1, rules);

        System.out.println("----------------------------------------------------------------------------");

        //now lets define another car and making the same checking
        CarInfo car2 = new CarInfo("XYZ5678", new Date(), CarType.TRUCK, 75, false);
        checkAndPrint(radar, car2, rules);

        System.out.println("----------------------------------------------------------------------------");

        //lets try entering the same car 1 again but with different violation rules
        CarInfo car3 = new CarInfo("ABC1234", new Date(), CarType.PRIVATE, 70, false);
        checkAndPrint(radar, car3, rules);

        System.out.println("----------------------------------------------------------------------------");

        //what about a car with no any violateion?
        CarInfo car4 = new CarInfo("SAFE001", new Date(), CarType.BUS, 40, true);
        checkAndPrint(radar, car4, rules);

        System.out.println("----------------------------------------------------------------------------");

        //lets think about the edge cases
        //what about the radar take empty rules how it will be handled ?

        List<Rule> emptyRules = new ArrayList<>();
        CarInfo car5 = new CarInfo("EMPTY001", new Date(), CarType.PRIVATE, 999, false);
        checkAndPrint(radar, car5, emptyRules);
        System.out.println("----------------------------------------------------------------------------");

        //now lets see the total fines
        System.out.println("          All fines (plate -> total)           ");
        for (Map.Entry<String, Integer> entry : radar.history.getAllFines().entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " EGP");
        }


        System.out.println("----------------------------------------------------------------------------");


        System.out.println("          Violated rules with count          ");
        for (Map.Entry<String, Integer> entry : radar.history.getAllViolatedRulesWithCount().entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


        System.out.println();


    }


    private static void checkAndPrint(Radar radar, CarInfo car, List<Rule> rules) {
        Observation observation = radar.checkRules(car, rules);
        if (observation == null) {
            System.out.println("No violations, car " + car.getPlateNumber() + " is safe.");
        } else {
            observation.display();
        }
        System.out.println();
    }
}
