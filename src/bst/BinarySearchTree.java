/*
 * Name: Zachary Pratt 
 * Assignment: Trees
 * Date: 15 April 2013
 * File: BinarySearchTree.java
 * 
 * Description: This is a simple linked implementation of a BinarySearchTree
 */
package bst;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author Zachary Pratt Gibbs
 */
public class BinarySearchTree<E extends Comparable<E>>
{
    private BSTNode<E> root;
    private int size;
    public BinarySearchTree()
    {
        root = null;
        size = 0;
    }
    public BinarySearchTree(E element)
    {
        root = new BSTNode<>(element);
        size = 1;
    }
    public BSTNode<E> root()
    {
        return root;
    }
    public int size()
    {
        return size;
    }
    public boolean add(E element)
    {
        if(this.size == 0)
        {
            root = new BSTNode<>(element);
            size++;
            return true;
        }
        return addInternal(root,element);
    }
    private boolean addInternal(BSTNode<E> temp, E element)
    {
        if(temp.compareTo(element) < 0)
        {
            if(temp.getRightChild() == null)
            {
                temp.setRightChild(new BSTNode<>(element));
                this.size++;
                return true;
            }
            temp = temp.getRightChild();
            return addInternal(temp, element);
        }
        else if(temp.compareTo(element) > 0)
        {
            if(temp.getLeftChild() == null)
            {
                temp.setLeftChild(new BSTNode<>(element));
                this.size++;
                return true;
            }
            temp = temp.getLeftChild();
            return addInternal(temp, element);
        }
        else
        {
            return false;
        }
    }
    public boolean remove(BSTNode<E> node)
    {
        if(this.size==0)
        {
            return false;
        }
        if(this.size == 1)
        {
            node.setLeftChild(null);
            node.setRightChild(null);
            node.setElement(null);
            size--;
            return true;
        }
        BSTNode<E> temp = node;
        if(node.getRightChild()== null)
        {
            if(node.getLeftChild() != null)
            {
                temp.getLeftChild().setParent(temp.getParent());
            }
        }
        temp = temp.getRightChild();
        while(temp.getLeftChild() != null)
        {
            temp = temp.getLeftChild();
        }
        if(temp.getRightChild() != null)
        {
            temp.getRightChild().setParent(temp.getParent());
        }
        temp.setLeftChild(node.getLeftChild());
        temp.setRightChild(node.getRightChild());
        temp.setParent(node.getParent());
        node.setParent(null);
        node.setLeftChild(null);
        node.setRightChild(null);
        size--;
        return true;
    }
    public BSTNode<E> find(E element)
    {
        if(this.size==0)
        {
            return null;
        }
        BSTNode<E> found = null;
        if(root.getElement().equals(element))
        {
            return root;
        }
        found = internalFind(root.getLeftChild(), element);
        if(found != null)
        {
            return found;
        }
        found = internalFind(root.getRightChild(), element);
        return found;
    }
    private BSTNode<E> internalFind(BSTNode<E> node, E element)
    {
        BSTNode<E> found = null;
        if(node.getElement().equals(element))
        {
            return node;
        }
        found = internalFind(node.getLeftChild(), element);
        if(found != null)
        {
            return found;
        }
        found = internalFind(node.getRightChild(), element);
        return found;
    }
    public void traverseInOrder(Visitor visitor)
    {
        if(this.size==0)
        {
            return;
        }
        if(root.getLeftChild() != null)
        {
           internalTraverseInOrder(visitor, root.getLeftChild());
        }
        visitor.visit(root);
        if(root.getRightChild() != null)
        {
            internalTraverseInOrder(visitor, root.getRightChild());
        }
    }
    private void internalTraverseInOrder(Visitor visitor, BSTNode<E> node)
    {
        if(node.getLeftChild() != null)
        {
            internalTraverseInOrder(visitor, node.getLeftChild());
        }
        visitor.visit(node);
        if(node.getRightChild() != null)
        {
            internalTraverseInOrder(visitor, node.getRightChild());
        }
    }
    public void traversePreOrder(Visitor visitor)
    {
        if(this.size==0)
        {
            return;
        }
        visitor.visit(root);
        if(root.getLeftChild() != null)
        {
           internalTraverseInOrder(visitor, root.getLeftChild());
        }
        if(root.getRightChild() != null)
        {
            internalTraverseInOrder(visitor, root.getRightChild());
        }
    }
    private void internalTraversePreOrder(Visitor visitor, BSTNode<E> node)
    {
        visitor.visit(node);
        if(node.getLeftChild() != null)
        {
            internalTraverseInOrder(visitor, node.getLeftChild());
        }
        if(node.getRightChild() != null)
        {
            internalTraverseInOrder(visitor, node.getRightChild());
        }
    }
    public void writeOut(String filename)
    {
        try 
        {
            SerialVisitorOut<E> sout = new SerialVisitorOut<>(filename, this.size);
            this.traversePreOrder(sout);
            sout.close();
        } 
        catch (IOException ex) 
        {
            System.out.println("File error");
        }
    }
    public void writeIn(String filename)
    {
        try
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            int newSize = in.readInt();
            for(int i = 0; i < newSize; i++)
            {
                this.add((E)in.readObject());
            }
        }
        catch(ClassNotFoundException | IOException ex)
        {
            System.out.println("Input Error");
        }
    }
    
}
