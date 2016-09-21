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

    public TapeDouble() {
        activeCell = new Cell();
    }

    public Cell getCurrentCell() {

        return activeCell;
    }

    public char getContent() {

        return activeCell.content;
    }

    public void setContent(char ch) {
        activeCell.content = ch;
        System.out.println(activeCell.content);
    }

    public void moveLeft() {
        Cell newCell = new Cell();
        if(activeCell.prev == null){
            leftCell = newCell;
        }
        else{
            leftCell.prev = newCell;
            newCell.prev = rightCell;
        }
        activeCell = newCell; 
    }

    public void moveRight() {
        Cell newCell = new Cell();
        if(activeCell.next == null){
            rightCell = newCell;
        }
        else{
            rightCell.next = newCell;
            newCell.prev = rightCell;
        }
        activeCell = newCell;
    }

    public String getTapeContents() {
        String output = "";


        return output;
    }

    public static void main(String[]args){
        TapeDouble tapeNew = new TapeDouble();
        
    }

}
