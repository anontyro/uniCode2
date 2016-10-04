/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uotp.projects.programming.week5;

/**
 *
 * @author Alex
 */
public class WordCheck {

    private String test = "temp";
    private String check = "test";

    public WordCheck() {
        int counter = 0;
        for (int i = 0; i < test.length(); i++) {

            for (int j = 0; j < check.length(); j++) {
                if (test.charAt(i) == check.charAt(j)) {
                    counter++;
                   break;
                }
            }

        }
        if (counter >= (test.length() - 1)) {
            System.out.println("Hit");
        } else {
            System.out.println("None");
        }
    }

    public static void main(String[] args) {
        WordCheck wc = new WordCheck();
    }
}
