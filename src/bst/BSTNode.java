/*
 * Name: Zachary Pratt 
 * Assignment: Trees
 * Date: 17 April 2013
 * File: BSTNode.java
 * 
 * Description: This is a node for the BinarySearchTree
 */
package bst;

/**
 *
 * @author Zachary Pratt Gibbs
 */
public class BSTNode<E extends Comparable<E>>
{
    private BSTNode<E> parent;
    private BSTNode<E> leftChild;
    private BSTNode<E> rightChild;
    private E element;
    /**
     * Constructor that takes an element
     * @param element Element for the node to hold.
     */
    public BSTNode(E element)
    {
        parent = null;
        rightChild = null;
        leftChild = null;
        this.element = element;
    }
    /**
     * Constructor that defines all parts of the node
     * @param parent Parent of the node
     * @param rightChild Right child of the node
     * @param leftChild Left child of the node
     * @param element Element for the node to hold.
     */
    public BSTNode(BSTNode parent, BSTNode rightChild, BSTNode leftChild, E element)
    {
        this.parent = parent;
        this.rightChild = rightChild;
        this.leftChild = leftChild;
        this.element = element;
    }
    /**
     * 
     * @return Element from the node
     */
    public E getElement() 
    {
        return element;
    }
    /**
     * Sets the element of the node
     * @param element Element held by the node
     */
    public void setElement(E element) 
    {
        this.element = element;
    }
    /**
     * Gets the parent of the node
     * @return Parent of the node
     */
    public BSTNode getParent() 
    {
        return parent;
    }
    /**
     * Sets the parent of the node
     * @param parent Parent of the node.
     */
    public void setParent(BSTNode parent) 
    {
        this.parent = parent;
    }
    /**
     * Get the left child of the node
     * @return Left Child of the node
     */
    public BSTNode getLeftChild() 
    {
        return leftChild;
    }
    /**
     * Set the Left child
     * @param leftChild the New left child
     */
    public void setLeftChild(BSTNode leftChild) 
    {
        this.leftChild = leftChild;
    }
    /**
     * Get the right child of the node
     * @return right child of the node
     */
    public BSTNode getRightChild() 
    {
        return rightChild;
    }
    /**
     * Set the right child of the node
     * @param rightChild new Right child of the node
     */
    public void setRightChild(BSTNode rightChild) 
    {
        this.rightChild = rightChild;
    }
    /**
     * CompareTo method to compare the element of the node
     * @param element Element to compare to
     * @return -1 if the element is less than the parameter element, 0 if they are equal or 1 if it is greater
     */
    public int compareTo(E element)
    {
        return this.element.compareTo(element);
    }
}
