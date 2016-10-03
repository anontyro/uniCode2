/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uotp.projects.programming.week3;

public class Tape {
	
	// Current cell pointer
	Cell currentCell; 
	 
	//Constructor for the Tape class.
	public Tape() {
		Cell newCell = new Cell();
		newCell.content = ' ';
		newCell.next = null;
		newCell.prev = null;
		currentCell = newCell;
	}
	 
	//Returns the current cell
	public Cell getCurrentCell() {
		return currentCell;
	}
	 
	//Returns the content in the current cell.
	public char getContent() {
		return currentCell.content;
	}
	 
	//set value of the current cell.
	public void setContent(char ch) { 
		currentCell.content = ch;
	}
	 
	//To the current cell left
	public void moveLeft() {
		if (currentCell.prev == null) {
			Cell newCell = new Cell();
			newCell.content = ' ';
			newCell.next = currentCell;
			newCell.prev = null;
			currentCell.prev = newCell;
		}
		currentCell = currentCell.prev;
	}
	 
	//To the current cell left
	public void moveRight() { 
		if (currentCell.next == null) {
			Cell newCell = new Cell();
			newCell.content = ' ';
			newCell.next = null;
			newCell.prev = currentCell;
			currentCell.next = newCell;
		}
		currentCell = currentCell.next;
	}
	 
	//Returns all the content in the cell
	public String getTapeContents() {
		Cell contents = currentCell;
		String allContent = " ";
		while (contents.prev != null){
			contents = contents.prev;
		}
		while (contents != null) {
			allContent += contents.content;
			contents = contents.next;
		}
		
		//Trim of white space or null characters in the cell.
		allContent = allContent.trim();
		return allContent;
	}
}