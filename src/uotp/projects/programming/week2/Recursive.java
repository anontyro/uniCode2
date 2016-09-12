package uotp.projects.programming.week2;

import java.util.Random;

/**
 * Simple class that creates a random sentence constructed of different parts of
 * speech
 */
public class Recursive {

    /*
     list of arrays used to hold all of the value for each part of speech used
     */
    private String[] conjunctionArray = {"and", "or", "but", "because"};
    private String[] properNounArray = {"Fred", "Jane", "Richard Nixon", "Miss America"};
    private String[] commonNounArray = {"man", "woman", "fish", "elephant", "unicorn"};
    private String[] determinerArray = {"a", "the", "every", "some"};
    private String[] adjectiveArray = {"big", "tiny", "pretty", "bald"};
    private String[] intransitiveVerbArray = {"runs", "jumps", "talks", "sleeps"};
    private String[] transitiveVerbArray = {"loves", "hates", "sees", "knows", "looks for", "finds"};
    private Random rand = new Random();

    //no args constructor
    public Recursive() {

    }

    //simpleSentence if 1/5 = conjunction +sentence
    public String sentence() {
        int ranNo = rand.nextInt(5);
        if (ranNo == 3) {
            return simpleSentence() + wordSelector("conjunction") + sentence();
        }

        return simpleSentence();
    }

    //nounPhrase + verbPhrase
    private String simpleSentence() {

        return nounPhrase() + verbPhrase();
    }

    /*
     properNoun OR
     determiner + (while loop adjective) + commonNoun if something then = who verbPhrase
    
     Control statement used to create that nounPhrase to allow for any of the above
     statements to be constructed
     */
    private String nounPhrase() {
        int ranNo = rand.nextInt(2);

        if (ranNo == 1) {
            int stop = rand.nextInt(10);
            String phrase = wordSelector("determiner") + " ";

            //do while loop to add adjectives 1/6 chance of adding one 
            do {
                stop = rand.nextInt(6);
                phrase += wordSelector("adjective") + " ";
            } while (stop != 2);

            phrase += wordSelector("common noun") + " ";

            //will create a who statement
            if (stop == 2) {
                phrase += "who " + verbPhrase();
            }
            return phrase + " ";
        } else {
            //if none then proper noun selected
            return wordSelector("proper noun") + " ";
        }

    }

    /*
     intransitiveVerb OR
     transitiveVerb + nounPhase OR
     is adjective OR
     believes that simpleSentence
    
    control statement for the verbPhrase creation
     */
    private String verbPhrase() {

        int select = rand.nextInt(4);
        if (select == 0) {
            return wordSelector("intransitive verb") + " ";
        } else if (select == 1) {
            return wordSelector("transitive verb") + " " + nounPhrase();
        } else if (select == 2) {
            return wordSelector("adjective");
        } else if (select == 3) {
            return "believes that " + simpleSentence() + " ";
        }

        return null;
    }

    /*
    wordSelector is a method that selected a random word from an array given
    set input values and pulls them to be used in the String.
    */
    private String wordSelector(String type) {
        String selection = "";

        type = type.trim().toLowerCase();

        if (type.equals("conjunction")) {
            int ranNo = rand.nextInt(conjunctionArray.length);
            return conjunctionArray[ranNo];
        } else if (type.equals("proper noun")) {
            int ranNo = rand.nextInt(properNounArray.length);
            return properNounArray[ranNo];
        } else if (type.equals("common noun")) {
            int ranNo = rand.nextInt(commonNounArray.length);
            return commonNounArray[ranNo];
        } else if (type.equals("determiner")) {
            int ranNo = rand.nextInt(determinerArray.length);
            return determinerArray[ranNo];
        } else if (type.equals("adjective")) {
            int ranNo = rand.nextInt(adjectiveArray.length);
            return adjectiveArray[ranNo];
        } else if (type.equals("intransitive verb")) {
            int ranNo = rand.nextInt(intransitiveVerbArray.length);
            return intransitiveVerbArray[ranNo];
        } else if (type.equals("tranitive verb")) {
            int ranNo = rand.nextInt(transitiveVerbArray.length);
            return transitiveVerbArray[ranNo];
        }

        return selection;
    }

    //test class
    public static void main(String[] args) {

        Recursive recurse = new Recursive();
        System.out.println(recurse.sentence());
    }

}
