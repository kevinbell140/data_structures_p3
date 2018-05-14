/*
Author: Kevin Bell
Course: COP3538
Project#: 3
Title: Doubly Linked List
Due Date: 10/25/2016

Builds and updates a doubly linked list with a stack
 */
package ds_p3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Reads input data from text files
 */
public class File {
        private FileReader fr;
        private BufferedReader br;
        
        //input vars
        private int number;
        private String name;
        private String firstName;
        private String middleName;
        private String lastName;
        private String party;
        private String code;
        private int years;
        private String state;
        private String input;
        
        //input arraylist
        private ArrayList<Presidents> fileData;
        
    /**
     * Constructor for File class
     * @return constructor
     * @param file The file to be read
     * @throws FileNotFoundException 
     */    
    public File(String file) throws FileNotFoundException{
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        
        fileData = new ArrayList<>();          
    }//end constructor
        

    /**
     * Parses data from input file
     * @return void
     * @param none
     * @throws IOException 
     */
    public void parse() throws IOException{

        while((input = br.readLine()) != null){
            try{
            
                number = Integer.parseInt(input.substring(0,2).trim());
                name = input.substring(2,25).trim();
                firstName = null;
                middleName = null;
                lastName = null;
                code = input.substring(25,27).trim();
                years = Integer.parseInt(input.substring(27,29).trim());
                party = input.substring(29,49).trim();
                state = input.substring(49, input.length());

                fileData.add(new Presidents(number, name, firstName, middleName, lastName, code, years, party, state));
            }
            catch(Exception e){               
            }//end try
        }//end while
    }//end parse()
    
    
    /**
     * Parses data from update file
     * @return void
     * @param none
     * @throws IOException 
     */
    public void parseUpdate() throws IOException{
                     
        while ((input = br.readLine()) != null){
            try{
                
                String[] inArray = new String[4];
            
                inArray = input.split(",");
            
                code = inArray[0];
                name = inArray[1];
                party = inArray[2];
                state = inArray[3];
                number = -1;
                firstName = null;
                middleName = null;
                lastName = null;
                years = -1;

                fileData.add(new Presidents(number, name, firstName, middleName, lastName, code, years, party, state));
            }
            catch(Exception e){                
            }//end try
        }//end while
    }//end parseUpdate()
    
    /**
     * Returns fileData to main
     * @return The fileData array list
     * @param none
     */   
    public ArrayList<Presidents> getFileData(){
          return fileData;
      }//end getFileData
    
    
    /**
     * Displays input Array
     * @return void
     * @param none
     */
    public void displayFileData(){
        for(int i = 0; i<fileData.size(); i++){
            System.out.println(fileData.get(i));
        }//end for
    }//end display
}//end File class

