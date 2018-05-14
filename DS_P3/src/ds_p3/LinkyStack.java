/*
Author: Kevin Bell
Course: COP3538
Project#: 3
Title: Doubly Linked List
Due Date: 10/25/2016

Builds and updates a doubly linked list with a stack
 */
package ds_p3;

import java.util.ArrayList;


/**
 * Provides properties and methods for the update stack
 */
public class LinkyStack {
    
        private ArrayList<Presidents> prezStack;
        
        private int stackElem;
        private int top;
    
        
    /**
     * Constructor for StackDrvr Class
     * @return constructor
     * @param none
     */
    public LinkyStack(){
        prezStack = new ArrayList<>();
        top = -1;
        stackElem = 0; 
    }//end constructor
    
    
    /**
     * Pushes presidents onto the update stack
     * @return void
     * @param president The president object to be pushed onto stack 
     */
    public void push(Presidents president){
        prezStack.add(president);
        ++top;
        stackElem++; 
    }//end push()
    
    
    /**
     * Pops presidents off of the update stack
     * @return The president removed from the top of the stack
     * @param none
     */
    public Presidents pop(){
        return prezStack.get(top--);   
    }//end pop()
    
    
    /**
     * Determines if the stack is empty
     * @return True if stack is empty
     * @param none
     */
    public boolean isEmpty(){
        return (top == -1);
    }//end isEmpty()
        
    
    /**
     * Returns the number of objects in the stack
     * @return The number of objects in the stack
     * @param none
     */
    public int getSize(){
        return stackElem;
    }//end size()
    
    
    /**
     * Displays the update stack
     * @return void
     * @param none
     */
    public void display(){

        getStackHeader();
        for (int i = top; i>=0; i--){
             System.out.println(prezStack.get(i).updateToString());        
        }//end for
        System.out.println("\n");
    }//end display()
    
    
    /**
     * Gets the header for stack when displayed
     * @return void
     * @param none
     */
    private void getStackHeader(){
        System.out.format("%-12s%-12s%-16s%-12s%-4s", "Last", "First", "State","Party", "Code");
        System.out.format("\n%-12s%-12s%-16s%-12s%-4s\n", "-------", "-------", "-----------", "----------", "-------");
    }//end getStackHeader()
}//end LinkyStack class
