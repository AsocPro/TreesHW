/*
 * Name: Zachary Pratt 
 * Assignment: Trees
 * Date: 17 April 2013
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
    private double threshold;
    /**
     * Print out a student if their GPA is higher than a threshhold
     * @param node Node to visit to get the student data
     */
    @Override
    public void visit(BSTNode<Student> node)
    {
        Student stu = node.getElement();
        if(stu.getGpa() >= threshold)
        {
            System.out.println(stu);
        }
    }
    /**
     * Set the GPA threshold
     * @param threshhold GPA threshold to set
     */
    public void setThreshold(double threshhold)
    {
        this.threshold = threshhold;
    }
    /**
     * Return the current threshold
     * @return Current Threshold
     */
    public double getThreshold()
    {
        return threshold;
    }
}
