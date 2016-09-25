/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uotp.projects.programming.week3;

/**
 *
 * @author Alex
 */
public class TapeDouble {
    
    private Cell leftCell;
    private Cell activeCell;
    private Cell rightCell;
    private int size;

    public TapeDouble() {
        activeCell = new Cell();
        activeCell.next = rightCell;
        activeCell.prev = leftCell;
        size = 0;
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    
    public void moveRight(){
        Cell tmp = new Cell();
        if(rightCell != null){
            rightCell.prev = tmp;
        }
        rightCell = tmp;
        activeCell = tmp;
        if(leftCell == null){
            leftCell = tmp;
        }
        size++;
        
    }
    
    public void moveLeft(){
        Cell tmp = new Cell();
        if(leftCell != null){
            leftCell.next = tmp;
        }
        leftCell = tmp;
        activeCell = tmp;
        if(rightCell == null){
            rightCell = tmp;
        }
        size++;
    }
    
    public void setContent(char ch){
        activeCell.content = ch;
        System.out.println(activeCell.content);
    }
    
    public char getContent(){
        return activeCell.content;
    }
    
    public String getTapeContents(){
        String output="";
        Cell tmp = rightCell;
        while(tmp != null){
            System.out.println(tmp.content);
            output += tmp.content;
            tmp = tmp.next;
        }
        return output;
    }
    


    public static void main(String[]args){
        TapeDouble tapeNew = new TapeDouble();
        tapeNew.setContent('A');
        tapeNew.moveRight();
        tapeNew.setContent('L');
        tapeNew.moveRight();
        tapeNew.setContent('E');
        tapeNew.moveLeft();
        System.out.println(tapeNew.size());
        System.out.println("content is: " +tapeNew.getTapeContents());
    }

}
