/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uotp.projects.programming.week5;

import java.io.*;
import java.util.*;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class SpellCheck {

    private HashSet dictionary;

    public SpellCheck(String file) {
        try {
            readTxt(file);
        } catch (IOException ex) {
            System.err.println("Error in parsing file try a new dir");
        }
        System.out.println(dictionary.size());

        String value = userInput();

        if (dictionary.contains(value)) {
            System.out.println("The word was typed correctly: " + value);
        } else {
            corrections(value, dictionary);
        }
    }

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

    private TreeSet corrections(String user, HashSet dictionary) {
        TreeSet suggestions = new TreeSet();
        Iterator iter = dictionary.iterator();
        int counter = 0;

        while (iter.hasNext()) {
            String temp = iter.next().toString();
            
            //check to see i the user word is majorly different in length to the dictionary word
            
            //check through the word for so many hits
            for(int i = 0; i < user.length(); i++){
                for(int j = 0; j<temp.length(); j++){
                    if(user.charAt(i)== temp.charAt(j)){
                        counter++;
                    }
                }
            }
            

            if (iter.hasNext()) {
                iter.next();
            } else {
                break;
            }
        }

        return suggestions;
    }

    private String userInput() {
        String userIn = "";

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter word to search... ");
        userIn = input.nextLine();

        System.out.println(userIn);
        return userIn;
    }

    public static void main(String[] args) {
        SpellCheck checker = new SpellCheck("./Words.txt");

    }
}
