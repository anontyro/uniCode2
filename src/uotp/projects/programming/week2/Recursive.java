/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uotp.projects.programming.week2;

import java.util.Random;

/**
 *
 * @author Alex
 */
public class Recursive {

    private String[] conjunctionArray = {"and", "or", "but", "because"};
    private String[] properNounArray = {"Fred", "Jane", "Richard Nixon", "Miss America"};
    private String[] commonNounArray = {"man", "woman", "fish", "elephant", "unicorn"};
    private String[] determinerArray = {"a", "the", "every", "some"};
    private String[] adjectiveArray = {"big", "tiny", "pretty", "bald"};
    private String[] intransitiveVerbArray = {"runs", "jumps", "talks", "sleeps"};
    private String[] transitiveVerbArray = {"loves", "hates", "sees", "knows", "looks for", "finds"};
    private Random rand = new Random();
    
    public Recursive() {

    }

    //simpleSentence if something then = conunction +sentence
    public String sentence() {
        int ranNo = rand.nextInt(5);
        if(ranNo == 3){
            return simpleSentence() + wordSelector("conjunction") + sentence();
        }

        return simpleSentence();
    }

    //nounPhrase + verbPhrase
    public String simpleSentence() {

        return nounPhrase() + verbPhrase();
    }

    /*
    properNoun OR
    determiner + (while loop adjective) + commonNoun if something then = who verbPhrase
     */
    public String nounPhrase() {
        int ranNo = rand.nextInt(2);
        
        if(ranNo == 1){
            int stop = rand.nextInt(10);
            String phrase = wordSelector("determiner") + " ";
            
            do{
              stop = rand.nextInt(5);
              phrase += wordSelector("adjective") + " ";
            }
            while(stop != 2);
            
            phrase+= wordSelector("common noun") + " ";
            
            if(stop ==2){
                phrase+= "who " + verbPhrase();
            }
            return phrase + " ";        
        }
        else{
            return wordSelector("proper noun") + " ";
        }
        
    }

    /*
    intransitiveVerb OR
    transitiveVerb + nounPhase OR
    is adjective OR
    believes that simpleSentence
     */
    public String verbPhrase() {
        
        int select = rand.nextInt(4);
        if(select == 0){
            return wordSelector("intransitive verb") + " ";
        }
        else if(select ==1){
            return wordSelector("transitive verb") + " " + nounPhrase();
        }
        else if(select ==2){
            return wordSelector("adjective");
        }
        else if(select ==3){
            return "believes that " + simpleSentence() + " ";
        }

        return null;
    }

    public String wordSelector(String type) {
        String selection = "";
        

        type = type.trim().toLowerCase();

        if (type.equals("conjunction")) {
            int ranNo = rand.nextInt(conjunctionArray.length);
            return conjunctionArray[ranNo];
        } else if (type.equals("proper noun")) {
            int ranNo = rand.nextInt(properNounArray.length);
            return properNounArray[ranNo];
        }
         else if (type.equals("common noun")) {
            int ranNo = rand.nextInt(commonNounArray.length);
            return commonNounArray[ranNo];
        }
         else if (type.equals("determiner")) {
            int ranNo = rand.nextInt(determinerArray.length);
            return determinerArray[ranNo];
        }
         else if (type.equals("adjective")) {
            int ranNo = rand.nextInt(adjectiveArray.length);
            return adjectiveArray[ranNo];
        }
         else if (type.equals("intransitive verb")) {
            int ranNo = rand.nextInt(intransitiveVerbArray.length);
            return intransitiveVerbArray[ranNo];
        }
         else if (type.equals("tranitive verb")) {
            int ranNo = rand.nextInt(transitiveVerbArray.length);
            return transitiveVerbArray[ranNo];
        }
        

        return selection;
    }
    
    
    
    
    
    public static void main(String []args){
        
        Recursive recurse = new Recursive();
        String selection = "common noun";
        System.out.println(recurse.sentence());
    }

}
