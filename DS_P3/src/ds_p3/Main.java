/*
Author: Kevin Bell
Course: COP3538
Project#: 3
Title: Doubly Linked List
Due Date: 10/25/2016

Builds and updates a doubly linked list with a stack
 */
package ds_p3;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * Builds and updates a doubly linked list with a stack
 */
public class Main {

    /**
     * Builds and updates a doubly linked list with a stack
     * @return void
     * @param args
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        PrezCollection myPresidents = new PrezCollection();   //creates instance of Presidents collection
        
        File prezData = new File("presidents.txt");     //reads data file     
        prezData.parse(); //parses file 
        
        for (Presidents president: prezData.getFileData())
            myPresidents.insert(president);         //inserts data into collection
        
        myPresidents.selectionSort();   //sorts data
        myPresidents.populateList();    //creates doubly linked list with data
        myPresidents.displayList();     //displays list forwards and backwards
        
        File update = new File("prezUpdate.txt");   //reads update file
        update.parseUpdate();       //parses update file
        
        for (Presidents presidents: update.getFileData())
            myPresidents.insertUpdate(presidents);     //inserts data into stack
        
        myPresidents.displayStack();        //displays stack
        myPresidents.updateList();          //updates linked list from stack
        myPresidents.displayList();         //displays updated linked list forwards and backwards
    }//end main()  
}//end Main class
