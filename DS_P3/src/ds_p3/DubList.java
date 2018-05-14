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
 * Provides properties and methods for a doubly linked list
 */
public class DubList {
        private Link first;
        private Link last;
    
    /**
     * Constructor for doubly linked list
     * @return constructor
     * @param none
     */
    public DubList(){
        
        first = null;
        last = null;
    }//end constructor
    
    
    /**
     * Determines if the list is empty
     * @return True if list is empty
     * @param none
     */
    public boolean isEmpty(){
        return first==null; 
    }//end isEmpty()
    
    
    /**
     * Inserts a new link at the end of the list
     * @return void
     * @param president The president inserted into the list 
     */
    public void insertLast(Presidents president){
        
        Link newLink = new Link(president);
        
        if (isEmpty()){
            first = newLink;
        }else{
            last.next = newLink;
            newLink.previous = last;
        }//end if
        last = newLink;
    }//end insertLast()
    
    
    /**
     * Displays the list from first to last
     * @return void
     * @param none
     */
    public void displayForward(){
        
        System.out.println("\tDoubly Linked List (first-->last) ");
        getListHeader();
        
        Link current = first;
        
        while(current != null){
            current.displayLink();
            current = current.next;
        }//end while       
        System.out.println(" ");
    }//end displayForward()
    
    
    /**
     * Displays the list last to first
     * @return void
     * @param none
     */
    public void displayBackward(){
        
        System.out.println("\tDoubly Linked List (last-->first) ");
        getListHeader();
        
        Link current = last;
        
        while(current != null){
            current.displayLink();
            current = current.previous;
        }//end while       
        System.out.println(" ");  
    }//end displayBackward()
  
    
    /**
     * Gets the column header for the list
     * @return void
     * @param none
     */
    private void getListHeader(){
        System.out.format("\n%-12s%-12s%-16s%-12s", "Last", "First", "State","Party");
        System.out.format("\n%-12s%-12s%-16s%-12s\n", "--------", "--------", "-------------","----------");
    }//end getListHeader()
  
    
    /**
     * Inserts a president into the correct position of the list
     * @return void
     * @param president The president inserted into the list 
     */
    public void insert(Presidents president){
       
        Link newLink = new Link(president);
        
        int count = 0; 
        int dupe = 1002;
        
        if(isEmpty()){      //list empty
            first = last = newLink;
            getTxnMessage(president, count);
            return;
        }//end if
        
        Link current = first;  //start at first link
        
        if (current.pData.getLast().compareTo(newLink.pData.getLast())>= 0){    //if new link last name goes before or matches last name of first link
            
            if (current.pData.getLast().equalsIgnoreCase(newLink.pData.getLast()) && current.pData.getFirst().compareToIgnoreCase(newLink.pData.getFirst())<0){ //if new last name matches and first name goes after current, insert 2nd
                current = current.next;
                count++;
                current = current.previous;
                newLink.next = current.next;
                current.next.previous = newLink;
                newLink.previous = current;
                current.next = newLink;
                getTxnMessage(president, count);
                return;
            }//end if
            if (current.pData.getLast().equalsIgnoreCase(newLink.pData.getLast()) && current.pData.getFirst().equalsIgnoreCase(newLink.pData.getFirst())){ //if new last name and new first name matches current, dupe add attempt
                getTxnMessage(president, dupe);
                return;
            }//end if
            
            newLink.next = first;      //if new last name goes before current last name OR (new last matches current last and new first goes before current first), insert first 
            first.previous = newLink;
            first = newLink;
            getTxnMessage(president, count);
            return;
           
        }//end if
       
        while(true){    //if new link goes anywhere but first
            if (newLink.pData.getLast().compareTo(current.pData.getLast())> 0){ // if new last name goes after current last name
               
                if(current.next == null){   // at end of the list? insert last
                   last.next = newLink;
                   newLink.previous = last;
                   last = newLink;
                   getTxnMessage(president, count);
                   return;
               }//end if
               
               current = current.next;  //move to next link
               count++;                //count link gone past
               
            }else if(newLink.pData.getLast().equalsIgnoreCase(current.pData.getLast())){ //if new last name matches current last name, compare first name
                
                if (newLink.pData.getFirst().compareToIgnoreCase(current.pData.getFirst()) < 0){ // if new first name goes before current first name, insert before
                    current = current.previous;
                    newLink.next = current.next;
                    current.next.previous = newLink;
                    newLink.previous = current;
                    current.next = newLink;
                    getTxnMessage(president, count);
                    return;
                }else if (newLink.pData.getFirst().compareToIgnoreCase(current.pData.getFirst())> 0 && current!=last){ //if new first name goes after current first name and current is not last, insert after
                    current = current.next; 
                    count++;    
                    current = current.previous;
                    newLink.next = current.next;
                    current.next.previous = newLink;
                    newLink.previous = current;
                    current.next = newLink;
                    getTxnMessage(president, count);
                    return;                
                }else if (newLink.pData.getFirst().compareToIgnoreCase(current.pData.getFirst())> 0 && current==last){ //if new first name goes after current first name and current is last, insert last
                    last.next = newLink;
                    newLink.previous = last;
                    last = newLink;
                    count++;
                    getTxnMessage(president,count);
                    return;
                }else       // if new first and last are same as current first and last, dupe add attempt
                    getTxnMessage(president, dupe);
                    return;

            }else{   //if new last name goes before current last name, insert before
                current = current.previous;
                newLink.next = current.next;
                current.next.previous = newLink;
                newLink.previous = current;
                current.next = newLink;
                getTxnMessage(president, count);
                return;
            }//end if   
        }//end while
    }//end insert()
    
    
    /**
     * Removes a president from the list
     * @return void
     * @param president The president removed from the list 
     */
    public void delete(Presidents president ){
        
        Link current = first;   //start at first link
        int count = 0;
        int notFound = 1001;
     
        while (!current.pData.getName().equalsIgnoreCase(president.getName())){ //while key president last name does not match current last name
            
            if(current.next == null){ //if end of list, return not found
                getTxnMessage(president, notFound);
                return;
            }//end if
            
           
            current= current.next;      //move to next link
            count++;                    //count movement
        }//end while
        
        if (current == first){      // if last name matches first link, delete first
            getTxnMessage(president, count);
            first = first.next;
            first.previous = null;
            
        }else if(current == last){   // if last name matches last link, delete last
            getTxnMessage(president, count);
            last = last.previous;
            last.next = null;
            
        }else{     //if last name matches current link, delete current
            current.previous.next = current.next;
            current.next.previous = current.previous;
            getTxnMessage(president, count);
        }//end if
    }//end delete()
    
    
    /**
     * Displays the correct report for a given update transaction
     * @param president
     * @param count 
     */
    private void getTxnMessage(Presidents president, int count){
        switch(count){
            case 1001:
                System.out.format("%5s%s%-12s%-12s\n", president.getCode()+": ", " ", president.getLast(),"Transaction Not Found");
                break;
            case 1002:
                System.out.format("%5s%s%-12s%-12s\n", president.getCode()+": ", " ", president.getLast(),"Dupe Add Attempt");
                break;
            default:
                System.out.format("%5s%s%-12s%-12s\n", president.getCode()+": ", " ", president.getLast(), count +" nodes");
                break;
        }//end switch
    }//end getTxnMessage
}//end DubList class
