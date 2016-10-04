package uotp.projects.programming.week5;

import java.io.*;
import java.util.*;
import java.util.Scanner;

/**
 *A simple class that will search a dictionary for the correct spelling of the word
 * 
 */
public class SpellCheck {

    private HashSet dictionary;

    /**
     * Constructor that requires the file to use as the dictionary.
     * @param file full file location of dictionary
     */
    public SpellCheck(String file) {
        //checks the file is readable
        try {
            readTxt(file); //saves the data to dictionary HashSet
        } catch (IOException ex) {
            System.err.println("Error in parsing file try a new dir");
        }
        System.out.println("Dictionary size: "+ dictionary.size());

        //call method to ask for user input
        String value = userInput();
        
        //check the dictionary first for the value and see if it is contained
        if (dictionary.contains(value)) {
            //for a hit
            System.out.println("The word was typed correctly: " + value);
        } else {
            //run corrections method if the word is not found
            corrections(value, dictionary);
        }
    }

    /*
    private method used to read all the words from teh dictionary and save them
    to the dictionary HashSet
    */
    private HashSet readTxt(String filename) throws IOException {
        dictionary = new HashSet();
        File inFile = new File(filename);
        BufferedReader bin = null;

        try {
            FileReader fin = new FileReader(inFile);
            bin = new BufferedReader(fin);
            String line = bin.readLine();
            while (line != null) {
                String temp = line.trim();
                dictionary.add(temp);
                line = bin.readLine();
            }
        } catch (IOException ex) {
            ex.getStackTrace();
        } finally {
            if (bin != null) {
                bin.close();
            }
        }

        return dictionary;
    }

    /*
    corrections method that is used to search through the dictionary looking
    for words that are suitably close, adding them to a TreeSet
    */
    private TreeSet corrections(String user, HashSet dictionary) {
        TreeSet suggestions = new TreeSet(); //creaton of a new TreeSet
        Iterator iter = dictionary.iterator(); //creation of an iterator

        /*
        main while loop to test all the words and letters within the word
        to find a suitable hit
        */
        while (iter.hasNext()) {
            String temp = iter.next().toString();
            int counter = 0; //hit counter
            //check through the word for hits
            for (int i = 0; i < user.length(); i++) { //pulls the user input letter
                //runs the letter over the entire word to see if it exists
                for (int j = 0; j < temp.length(); j++) { 
                    //if a match is found add to counter and break current loop
                    if (user.charAt(i) == temp.charAt(j)) {
                        counter++;
                        break;
                    }
                }
                /*
                 to add a tolarance for what words are returned
                 this is to ensure not every word which matches one letter is returned
                 */
                int tolerance = 0;
                if (user.length() == 3) {
                    tolerance = 2;
                } else if (user.length() == 2) {
                    tolerance = 1;
                } else {
                    tolerance = user.length() - 1;
                }
                if (counter >= tolerance) {
                    if ((temp.length() - user.length()) < 2) {
                        suggestions.add(temp);
                    }

                }
            }
            //check to see if the list is at the end if not change word
            if (iter.hasNext()) {
                iter.next();
            } else {
                break;
            }
        }
        
        //results
        if (suggestions.size() == 0) { //for no hits
            System.out.println("Sorry, " + user + " has no hits");
            return null;
        } else { //all others

            System.out.println("Size of suggestions: " + suggestions.size() + "\n" + suggestions.toString());
            return suggestions;
        }
    }

    /*
    private method used to allow the user to add only text to be searched
    */
    private String userInput() {
        String userIn = "";

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter word to search... ");
        userIn = input.nextLine();
        userIn = userIn.replaceAll("[^a-zA-Z]", "");

        return userIn;
    }

    //test class
    public static void main(String[] args) {
        SpellCheck checker = new SpellCheck("./words.txt");

    }
}
