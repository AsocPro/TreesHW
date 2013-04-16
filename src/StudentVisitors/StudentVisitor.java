/*
 * Name: Zachary Pratt 
 * Assignment: Trees
 * Date: 15 April 2013
 * File: StudentVisitor.java
 * 
 * Description: Interface for a Student Visitor
 */
package StudentVisitors;

import StudentDatabase.Student;
import bst.Visitor;
import bst.BSTNode;

/**
 *
 * @author Zachary Pratt Gibbs
 */
public interface StudentVisitor extends Visitor<Student>
{
    /**
     * visitor that takes a Student
     * @param node Node to visit.
     */
    @Override
    public void visit(BSTNode<Student> node);
}
