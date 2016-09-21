/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uotp.projects.programming.week3;

import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class Tape {

    private Cell activeCell;
    private Cell lastCell;

    public Tape() {
        activeCell = new Cell();
        lastCell = new Cell();
    }

    public Cell getCurrentCell() {

        return activeCell;
    }

    public char getContent() {

        return activeCell.content;
    }

    public void setContent(char ch) {
        activeCell.content = ch;
    }

    public void moveLeft() {
        Cell prevCell = new Cell();
        if (isEmpty()) {
            activeCell = prevCell;
        } else {
            lastCell.next = prevCell;
            System.out.println(activeCell.content);
            prevCell.prev = activeCell;
        }

        activeCell = prevCell;

    }

    public void moveRight() {
        Cell nextCell = new Cell();
        if (isEmpty()) {
            lastCell = nextCell;
        } else {
            activeCell.prev = nextCell;
            System.out.println(activeCell.content);
            nextCell.next = activeCell;
        }

        activeCell = nextCell;

    }

    public String getTapeContents() {
        String output = "";
        Cell theCell = activeCell;
        while (theCell != null) {

            output += theCell.content;

            theCell = theCell.next;

        }

        return output;
    }

    private boolean isEmpty() {
        return (activeCell == null);
    }

}
