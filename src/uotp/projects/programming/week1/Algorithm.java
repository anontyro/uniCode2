/*
output

First array, small 1000Selection Sort starting
The sort took: 4mili-seconds
Array sort started
Array sort finished, it took: 1 mili-seconds
----------------------------------------------
Second array, medium 10000Selection Sort starting
The sort took: 48mili-seconds
Array sort started
Array sort finished, it took: 0 mili-seconds
----------------------------------------------
Third array, large 100000Selection Sort starting
The sort took: 3680mili-seconds
Array sort started
Array sort finished, it took: 2 mili-seconds
 */

package uotp.projects.programming.week1;

import java.util.Arrays;

/**
 * A simple class that creates two arrays and contains two sorting procedures 
 * which record time taken
 */
public class Algorithm {
    
    private int arraySize = 0;
    private int[] list1;
    private int[] list2;
           
   /**
    * Creates an Algorithm object that takes one argument to build the two arrays
    * for benchmarking.
    * @param arraySize int used to state the size of arrays to create.
    */
    public Algorithm(int arraySize){
        this.arraySize = arraySize;
        buildArrays();  
    }
    
    /*
    method that generates a big pesudo-random number
    */
    private int randomNumber(){
        int rand = (int)(Integer.MAX_VALUE*Math.random());
               
        return rand;
    }
    
    /*
    method used to build the two arrays containing identical data for benchmarking
    */
    private void buildArrays(){
        list1 = new int[arraySize];
        list2 = new int[arraySize];
        
        for(int i = 0; i < list1.length; i++){
            list1[i] = randomNumber();
        }
        list2 = list1; 
    }
    
    /**
     * return the first array object.
     * @return int array
     */
    public int[] getArray1(){
        return list1;
    }
    
    /**
     * return the second array object.
     * @return int array
     */
    public int[] getArray2(){
        return list2;
    }
    
    /**
     * get the size of arrays created in this class 
     * @return int value for the array size
     */
    public int getArraySize(){
        return arraySize;
    }
    
    /**
     * Method to use the Arrays sort method and records the time taken
     * @param int array
     * @return the array after it has been sorted
     */
    public int[] arraySort(int[]array){
        System.out.println("Array sort started");
        long startTime = System.currentTimeMillis();
        
        Arrays.sort(array);
        
        long timeTaken = System.currentTimeMillis() - startTime;
        
        System.out.println("Array sort finished, it took: " +timeTaken +" mili-seconds" );
        return array;
    }
    
    /**
     * Method to run a selection sort algorithm on the array.
     * @param int array
     * @return sorted version of the int array
     */
    public int[] selectionSort(int[]array){
        
        System.out.println("Selection Sort starting");
        long startTime = System.currentTimeMillis();
        
        for(int i = 0; i <array.length-1; i++){
            int index = i;
            for(int j = i+1; j<array.length;j++){
                if(array[j] < array[index]){
                    index = j;
                }
            }
            
            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println("The sort took: " + (timeTaken) + "mili-seconds");
        
        return array;
    }
    
    /**
     * simple string method that will return the two strings listed
     * @return String
     */
    public String toString(){
        String output = "First Array: \n";
        String list2String = "Seccond Array: \n";
        
        for(int i = 0; i < list1.length;i++){
            output+= "(" + i + ")" + list1[i] +"\n";
            list2String += "(" + i + ")" + list2[i] +"\n";
        }
        
        
        return output + "--------------------\n" 
                +list2String;
    }
    
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
