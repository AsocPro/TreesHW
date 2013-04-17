/*
 * Name: Zachary Pratt 
 * Assignment: Trees
 * Date: 17 April 2013
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
    private double threshold;
    /**
     * Prints a student out if they have  aGPA that is less than the threshhold
     * @param node Node to Visit for the student data
     */
    @Override
    public void visit(BSTNode<Student> node)
    {
        Student stu = node.getElement();
        if(stu.getGpa() <= threshold)
        {
            System.out.println(stu);
        }
    }
    /**
     * Set the GPA threshold
     * @param threshhold Threshold to set
     */
    public void setThreshold(double threshhold)
    {
        this.threshold = threshhold;
    }
    /**
     * Returns the currently set threshold
     * @return Current Threshohld
     */
    public double getThreshold()
    {
        return threshold;
    }
}
