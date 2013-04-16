/*
 * Name: Zachary Pratt 
 * Assignment: Trees
 * Date: 15 April 2013
 * File: Visitor.java
 * 
 * Description: This is an Interface for a standard visitor of the BinarySearchTree.
 */
package bst;

import bst.BSTNode;

/**
 *
 * @author Zachary Pratt Gibbs
 */
public interface Visitor<E extends Comparable<E>>
{
    /**
     * Used to visit a node in the BinarySearch Tree
     * @param node The node to visit.
     */
    public void visit(BSTNode<E> node);
}
