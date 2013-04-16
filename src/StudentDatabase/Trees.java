/*
 * Name: Zachary Pratt 
 * Assignment: Trees
 * Date: 15 April 2013
 * File: Trees.java
 * 
 * Description: Main method controlling the basic functions from the Backend.java file
 */
package StudentDatabase;

/**
 *
 * @author Zachary Pratt Gibbs
 */
public class Trees 
{

    /**
     * Main method that runs the program
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Backend database = new Backend();
        database.readData();
        while(database.mainMenu())
        {
            //running running running
            database.writeData();
            //After everything it saves the database.
        }
        database.writeData();
    }  
}
