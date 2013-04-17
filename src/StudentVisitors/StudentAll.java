/*
 * Name: Zachary Pratt 
 * Assignment: Trees
 * Date: 17 April 2013
 * File: StudentAll.java
 * 
 * Description: Visitor to print out all students
 */
package StudentVisitors;

import StudentDatabase.Student;
import bst.BSTNode;

/**
 *
 * @author Zachary Pratt Gibbs
 */
public class StudentAll implements StudentVisitor
{
    /**
     * Prints out all students
     * @param node Node to Get student data from.
     */
    @Override
    public void visit(BSTNode<Student> node)
    {
        Student stu = node.getElement();
        System.out.println(stu);
    }
}
