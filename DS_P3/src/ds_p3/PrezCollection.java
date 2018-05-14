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
 * Contains properties and methods for a collection of presidents 
 * 
 */
public class PrezCollection {
    
        private Presidents[] myPresidents;
        private int pElem;
        private DubList prezList;
        private LinkyStack addStack;
        private LinkyStack delStack;
        private LinkyStack invalidStack;
    

    /**
     * Constructor for MyPresidents collection
     * @retrun constructor
     * @param none
     */
    public PrezCollection(){
        myPresidents = new Presidents[44];
        pElem = 0;
        
        prezList = new DubList();
        addStack = new LinkyStack();
        delStack = new LinkyStack();
        invalidStack = new LinkyStack();
    }//end constructor
    
    
    /**
     * Inserts a president into the collection array
     * @return none
     * @param president The president being added to the collection
     */
    public void insert(Presidents president){
        
        nameSplitter(president);
        myPresidents[pElem++] = president;
    }//end insert()
    
    
    /**
     * Displays the collection array
     * @return void
     * @param none
     */
    public void display(){
        for (Presidents president: myPresidents){
            System.out.println(president.toString());
        }//end for
        System.out.println(" ");
    }//end display()
    
    
    /**
     * Splits a president's full name into a first, middle, and last name
     * @return void
     * @param president The president who's name is being split 
     */
    private void nameSplitter(Presidents president){
        
        String[] nameArray = new String[3];
        
        String name = president.getName();
        
        nameArray = name.split("\\s+");
        
        if (nameArray.length ==2){
            president.setFirst(nameArray[0]);
            president.setLast(nameArray[1]);    
        }else{
            president.setFirst(nameArray[0]);
            president.setMiddle(nameArray[1]);
            president.setLast(nameArray[2]);
        }//end if
    }//end nameSplitter()
    
    
    /**
     * Sorts the collection array by last name 
     * @return void
     * @param none
     */
    public void selectionSort(){
        int in, out, min;
        
        for (out = 0; out<pElem-1; out++){
            min = out;
            for(in = out+1; in<pElem; in++){
                if(myPresidents[in].getLast().compareTo(myPresidents[min].getLast()) < 0){
                    min = in;
                }//end if
            }//end for
            swap(out, min);
        }//end for
    }//end selectionSort()
        
    
    /**
     * Swaps the position of two presidents in the collection array
     * @return void
     * @param one The president in position one of the array
     * @param two The president in position two of the array
     */
    private void swap(int one, int two){
       Presidents temp = myPresidents[one];
       myPresidents[one] = myPresidents[two];
       myPresidents[two] = temp;
    }//end swap()
    
    
    /**
     * Inserts a president into the doubly linked list
     * @return void
     * @param none
     */
    public void populateList(){
        for (Presidents president: myPresidents){
            if(president.getParty().equalsIgnoreCase("republican")){
                prezList.insertLast(president);
            }//end if
        }//end for
    }//end populateList()
        
    
    /**
     * Displays the doubly linked list forward and backward
     * @return void
     * @param none
     */
    public void displayList(){
        System.out.println(" ");
        prezList.displayForward();
        System.out.println(" ");
        prezList.displayBackward();
        System.out.println(" ");
    }//end displayList()
    
    
    /**
     * Inserts presidents from update file into correct update stack
     * @return void
     * @param president The president pushed onto the stack 
     */
    public void insertUpdate(Presidents president){

        nameSplitter(president);
        
        if(president.getCode().equalsIgnoreCase("a")){      
            addStack.push(president);
        }else if(president.getCode().equalsIgnoreCase("d")){   
            delStack.push(president);
        }else{
            invalidStack.push(president);   
        }//end if
    }//end getUpdate
    
    
    /**
     * Displays all three update stacks
     * @return void
     * @param none
     */
    public void displayStack(){
        System.out.println("\tUpdate Stack: Adds\n");
        addStack.display();
        System.out.println("\tUpdate Stack: Deletes\n");
        delStack.display();
        System.out.println("\tUpdate Stack: Invalid\n");
        invalidStack.display();
    }//end displayStack
    
    
    /**
     * Inserts presidents on update stack into the doubly linked list
     * @return void
     * @param none
     */
    public void updateList(){
        
        getUpdateHeader();
        for (int i = 0; i<addStack.getSize(); i++){    //add
            Presidents president = addStack.pop();
                prezList.insert(president);
        }//end for
        
        for (int i = 0; i<delStack.getSize(); i++){    //delete
            Presidents president = delStack.pop();
                prezList.delete(president);   
        }//end for
        for (int i = 0; i<invalidStack.getSize(); i++){    //invalid
            Presidents president = invalidStack.pop();
            System.out.format("%5s%s%-12s%-12s\n", president.getCode()+": ", " ", president.getLast(), "Invalid Transaction Type");
            System.out.println(" ");
        }//end for              
    }//end updateList
    
    
    /**
     * Gets the header for update transactions
     * @return void
     * @param none
     */
    private void getUpdateHeader(){
        System.out.println("\tTransaction processing ");
        System.out.format("\n%-6s%-12s%-12s", "Type", "Name", "Nodes Preceding");
        System.out.format("\n%-6s%-12s%-12s\n", "-----", "----------", "-----------------");
    }//end getUpdateHeader()
}//end MyPresidents class

 
