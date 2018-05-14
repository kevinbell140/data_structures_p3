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
 *
 * Provides properties and methods for a Link
 */
public class Link {
    
       public Presidents pData;
       public Link next;
       public Link previous;
   
   
   /**
    * Constructor for a Link
    * @return constructor
    * @param president The president data for a link
    */
   public Link (Presidents president){
       pData = president;
   }//end constructor
   
   
   /**
    * Displays the data of a link to a formatted string
    * @return void
    * @param none
    */
   public void displayLink(){
       System.out.println(pData.toString());
   }//end displayLink()
}//end Link Class
