/*
 * Name: Zachary Pratt 
 * Assignment: Trees
 * Date: 17 April 2013
 * File: StudentMajor.java
 * 
 * Description: Visitor to print out the Students with a specific major
 */
package StudentVisitors;

import StudentDatabase.Student;
import bst.BSTNode;

/**
 *
 * @author Zachary Pratt Gibbs
 */
public class StudentMajor implements StudentVisitor
{
    private String major;
    /**
     * Prints the Student out if the Major is as specified
     * @param node The node to visit
     */
    @Override
    public void visit(BSTNode<Student> node)
    {
        Student stu = node.getElement();
        if(stu.getMajor().equalsIgnoreCase(major))
        {
            System.out.println(stu);
        }
    }
    /**
     * Return the specified major
     * @return Specified Major
     */
    public String getMajor() 
    {
        return major;
    }
    /**
     * Specify a major
     * @param major Major to specify
     */
    public void setMajor(String major) 
    {
        this.major = major;
    }
}
