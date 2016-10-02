/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uotp.projects.programming.week5;

import java.io.*;
import java.util.HashSet;
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
        System.out.println(dictionary.size() + "\n" 
                +dictionary.toString());
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
    
    private String userInput(){
        String userIn = "";
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter word to search... ");
        userIn = input.nextLine();
        
        System.out.println(userIn);
        return userIn;
    }
    
    public static void main(String[]args){
        SpellCheck checker = new SpellCheck("./Words.txt");
        
    }
}
