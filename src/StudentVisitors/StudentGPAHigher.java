/*
 * Name: Zachary Pratt 
 * Assignment: Trees
 * Date: 15 April 2013
 * File: STudentGPAHigher.java
 * 
 * Description: Visitor that Prints out a student if their GPA is above a threshhold
 */
package StudentVisitors;

import StudentDatabase.Student;
import bst.BSTNode;

/**
 *
 * @author Zachary Pratt Gibbs
 */
public class StudentGPAHigher implements StudentVisitor
{
    private double threshhold;
    /**
     * Print out a student if their GPA is higher than a threshhold
     * @param node Node to visit to get the student data
     */
    @Override
    public void visit(BSTNode<Student> node)
    {
        Student stu = node.getElement();
        if(stu.getGpa() >= threshhold)
        {
            System.out.println(stu);
        }
    }
    /**
     * Set the GPA threshhold
     * @param threshhold GPA threshhold to set
     */
    public void setThreshhold(double threshhold)
    {
        this.threshhold = threshhold;
    }
    /**
     * Return the current threshhold
     * @return Current Threshhold
     */
    public double getThreshhold()
    {
        return threshhold;
    }
}
