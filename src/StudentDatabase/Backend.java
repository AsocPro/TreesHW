/*
 * Name: Zachary Pratt 
 * Assignment: Trees
 * Date: 17 April 2013
 * File: Backend.java
 * 
 * Description: This is the backend of the Student database.
 */
package StudentDatabase;

import StudentVisitors.StudentAll;
import StudentVisitors.StudentGPAHigher;
import StudentVisitors.StudentGPALower;
import StudentVisitors.StudentMajor;
import bst.BSTNode;
import bst.BinarySearchTree;
import java.util.Scanner;

/**
 *
 * @author Zachary Pratt Gibbs
 */
public class Backend 
{
    private BinarySearchTree data;
    private Scanner scr;
    /**
     * Constructor
     */
    public Backend()
    {
        data = new BinarySearchTree();
        scr = new Scanner(System.in);
    }
    /**
     * Runs the main menu
     * @return if the menu is to be ran again
     */
    public boolean mainMenu()
    {
        System.out.println("Student Database");
        System.out.println("");
        System.out.println("1. Add a Student");
        System.out.println("2. Delete a Student");
        System.out.println("--List Students by:");
        System.out.println("3. All Students");
        System.out.println("4. A Specific Major");
        System.out.println("5. GPA above a value");
        System.out.println("6. BPA below a value");
        System.out.println("");
        System.out.println("Other Key will Exit");
        String choice = scr.next();
        switch(choice)
        {
            case "1":
                this.add();
                break;
            case "2":
                this.delete();
                break;
            case "3":
                this.list(1);
                break;
            case "4":
                this.list(2);
                break;
            case "5":
                this.list(3);
                break;
            case "6":
                this.list(4);
                break;
            default:
                System.out.println("Invalid Input\nProgram Exiting");
                return false;
        }
        return true;
    }
    /**
     * add() helper method
     */
    private void add()
    {
        System.out.println("Enter a student number.");
        int num = scr.nextInt();
        System.out.println("Enter a last name for the student");
        String last = scr.next();
        System.out.println("Enter a first name for the student");
        String first = scr.next();
        System.out.println("Enter a major for the student");
        scr = new Scanner(System.in);
        String major = scr.nextLine();
        System.out.println("Enter a GPA for the student");
        double gpa = scr.nextDouble();
        data.add(new Student(num, last, first, major, gpa));
    }
    /**
     * delete() helper method
     */
    private void delete()
    {
        if(data.size() == 0)
        {
            System.out.println("Database is empty");
            return;
        }
        System.out.println("Enter the student number to delete");
        int num = scr.nextInt();
        BSTNode<Student> stu = data.find(new Student(num, "",""));
        Student deleted = new Student(stu.getElement().getNumber(),
                stu.getElement().getLastName(), stu.getElement().getFirstName(),
                stu.getElement().getMajor(), stu.getElement().getGpa());
        boolean worked = data.remove(stu);
        System.out.println("You deleted this student");
        System.out.println(deleted);
    }
    /**
     * list Helper method
     * @param type  Type of list to do.
     */
    private void list(int type)
    {
        switch(type)
        {
            case 1:
                System.out.println("#\tName\t\tMajor\t\tGPA");
                data.traverseInOrder(new StudentAll());
                break;
            case 2:
                
                StudentMajor visitMajor = new StudentMajor();
                System.out.println("Type the major to search for and press enter.");
                String major = scr.next();
                visitMajor.setMajor(major);
                System.out.println("#\t\tName\tMajor\t\tGPA");
                data.traverseInOrder(visitMajor);
                
                break;
            case 3:
                StudentGPAHigher visitGPAHigh = new StudentGPAHigher();
                System.out.println("Enter the GPA threshhold.");
                double thresh = scr.nextDouble();
                visitGPAHigh.setThreshold(thresh);
                System.out.println("#\tName\t\tMajor\t\tGPA");
                data.traverseInOrder(visitGPAHigh);
                
                break;
            case 4:
                StudentGPALower visitGPALow = new StudentGPALower();
                System.out.println("Enter the GPA threshhold.");
                double thresh2 = scr.nextDouble();
                visitGPALow.setThreshold(thresh2);
                System.out.println("#\tName\t\tMajor\t\tGPA");
                data.traverseInOrder(visitGPALow);
                break;
        }
    }
    /**
     * Read in data from file
     */
    public void readData()
    {
        data.writeIn("test.zpg");
    }
    /**
     * Write data out to file
     */
    public void writeData()
    {
        data.writeOut("test.zpg");
    }
}
