package org.example;
import java.util.List;
import java.util.ArrayList;

public class Radar {

    //here it can have any information about the radar itself like name and location for example
    private String name;
    private String location;

    //is the radar need to store inside it the rules? and update it to itself if there is anychange happened to it? or it can be psased to it from the main
    //or it can take it by accessing the get all rules function of the all rules handler class but there is no meaning to store rules inside radar

    History history;


    public Radar(String name, String location){
        this.name=name;
        this.location=location;
        this.history = new History();
    }


    //and the most important part related to radar that it will responable for checking about this car if it is violate the rules or not
    public Observation checkRules(CarInfo car,List<Rule> rules){
        //now we take snapshoted from the car info that passed so we will need to ensure that this car not vioolated all rules that defines by the the rule handler

        ArrayList<Rule> violatedRules= new ArrayList<>();
        //so first we will need to start with looping over all rules
        for (Rule rule : rules){
            if (rule.isViolated(car)){
                //so we will add it to the violated
                violatedRules.add(rule);
            }

        }

        //so after checking the radar will making observation if there is violated rules or null if there is not
        if (violatedRules.size()==0) return null;
        else {
            Observation observation=new Observation(car,violatedRules);
            //but first we need to save ti in the history
            history.recordObservationIntoHistory(observation);
            return observation;
        }

    }
}
