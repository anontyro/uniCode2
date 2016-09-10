/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uotp.projects.programming.week1;

/**
 *
 * @author Alex
 */
public class SortingAlg{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Algorithm arraySmall = new Algorithm(1000);

        System.out.print("First array, small " + arraySmall.getArraySize());

        int[] array = arraySmall.getArray1();

        int[] array2 = arraySmall.getArray2();

        arraySmall.selectionSort(array);

        arraySmall.arraySort(array2);

        System.out.println("----------------------------------------------");

        Algorithm arrayMedium = new Algorithm(10000);

        System.out.print("Second array, medium " + arrayMedium.getArraySize());

        int[] arrayMed1 = arrayMedium.getArray1();

        int[] arrayMed2 = arrayMedium.getArray2();

        arrayMedium.selectionSort(arrayMed1);

        arrayMedium.arraySort(arrayMed2);

        System.out.println("----------------------------------------------");

        Algorithm arrayLarge = new Algorithm(100000);

        System.out.print("Third array, large " + arrayLarge.getArraySize());

        int[] arrayLg1 = arrayLarge.getArray1();

        int[] arrayLg2 = arrayLarge.getArray2();

        arrayLarge.selectionSort(arrayLg1);

        arrayLarge.arraySort(arrayLg2);

        System.out.println("----------------------------------------------");
    }
}
