/*
 * Name: Zachary Pratt 
 * Assignment: Trees
 * Date: 15 April 2013
 * File: STudentGPALower.java
 * 
 * Description: Visitor to print out a Student if they GPA is less than a threshhold
 */
package StudentVisitors;

import StudentDatabase.Student;
import bst.BSTNode;

/**
 *
 * @author Zachary Pratt Gibbs
 */
public class StudentGPALower implements StudentVisitor
{
    private double threshhold;
    /**
     * Prints a student out if they have  aGPA that is less than the threshhold
     * @param node Node to Visit for the student data
     */
    @Override
    public void visit(BSTNode<Student> node)
    {
        Student stu = node.getElement();
        if(stu.getGpa() <= threshhold)
        {
            System.out.println(stu);
        }
    }
    /**
     * Set the GPA threshhold
     * @param threshhold Threshhold to set
     */
    public void setThreshhold(double threshhold)
    {
        this.threshhold = threshhold;
    }
    /**
     * Returns the currently set threshhold
     * @return Current Threshhohld
     */
    public double getThreshhold()
    {
        return threshhold;
    }
}
