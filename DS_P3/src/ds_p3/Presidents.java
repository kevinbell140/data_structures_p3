/*
Author: Kevin Bell
Course: COP3538
Project#: 3
Title: Doubly Linked List
Due Date: 10/25/2016

Builds and updates a doubly linked list with a stack
 */
package ds_p3;

/**
 *  Provides properties and methods for president objects
 */
public class Presidents {
        
       //Presidental attributes 
        private int number;
        private String name;
        private String firstName;
        private String middleName;
        private String lastName;
        private String code;
        private int years;
        private String party;
        private String state;
    
    /**
     * Creates an object instance of the Presidents class
     * @return Constructor for Presidents
     * @param pNumber President's number
     * @param pName President's name
     * @param pFirst President's first name
     * @param pMiddle President's middle name
     * @param pLast President's last name
     * @param pCode President's code
     * @param pTerm President's term
     * @param pParty President's party
     * @param pState President's state
     */    
    public Presidents( int pNumber, String pName, String pFirst, String pMiddle, String pLast, String pCode, int pTerm, String pParty, String pState){
    
        number = pNumber;
        name = pName;
        firstName = pFirst;
        middleName = pMiddle;
        lastName = pLast;
        code = pCode;
        years = pTerm;
        party = pParty;
        state = pState;     
    }//end constructor 
    
    
    /**
     * Gets the number of a president
     * @return the number of a president
     * @param none
     */
    public int getNumber(){
        return number;
    } //end getNumber()

    
    /**
     * Gets the name of a president
     * @return the name of a president
     * @param none
     */
    public String getName(){
        return name;
    }//end getName()
    
    
    /**
     * Gets the code of a president
     * @return the code of a president
     * @param none
     */
    public String getCode(){
        return code;
    }//end getCode()
    
    
    /**
     * Gets the term of a president
     * @return the years of a president
     * @param none
     */
    public int getYears(){
        return years;
    }//getYears()
    
    
    /**
     * Gets the party of a president
     * @return the party of a president
     * @param none
     */
    public String getParty(){
        return party;
    }//end getParty()
    
    
    /**
     * Gets the state of a president
     * @return the state of a president
     * @param none
     */
    public String getState(){
        return state;
    }//getState()
    
    
    /**
     * Sets the first name of a president
     * @return void
     * @param name The president's full name
     */
    public void setFirst(String name){
        firstName = name;
    }//end setFirst
    
    
    /**
     * Gets the first name of a president
     * @return void
     * @param none
     */
    public String getFirst(){
        return firstName;
    }//end getFirst()
    
    
    /**
     * Sets the middle name of a president
     * @return void
     * @param name The president's full name
     */
    public void setMiddle(String name){
        middleName = name;
    }// end setMiddle;
    
    
   /**
    * Sets the last name of a president
    * @return void
    * @param name The president's full name
    */
    public void setLast (String name){
        lastName = name;
    }//end setLast()
    
    
    /**
     * Gets the last name of a president
     * @return void
     * @param none
     */
    public String getLast(){
        return lastName;
    }//end getLast()

    
    /**
     * Gets a formatted string containing information about a president
     * @return a formatted string containing information about a president
     * @param none
     */
    @Override
    public String toString(){
        return String.format("%-12s%-12s%-16s%-12s", lastName, firstName, state, party);
    } //end toString()

    
    /**
     * Gets a formatted string containing information about a president
     * @return a formatted string containing information about a president
     * @param none
     */
    public String updateToString(){
        return String.format("%-12s%-12s%-16s%-12s%3s", lastName, firstName, state, party, code);
    }//end updateToString()
}//end Presidents class    

