/*
 * Name: Zachary Pratt 
 * Assignment: Trees
 * Date: 17 April 2013
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
                BSTNode<E> tempNode = new BSTNode<>(temp,null,null,element);
                temp.setRightChild(tempNode);
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
                BSTNode<E> tempNode = new BSTNode<>(temp,null,null,element);
                temp.setLeftChild(tempNode);
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
        //Check to see if it isn't a leaf.
        if(node.getLeftChild() != null || node.getRightChild() != null)
        {
            BSTNode<E> temp = node;
            //Choose the side to use to replace.
            if(temp.getRightChild()!= null)
            {
                temp = temp.getRightChild();
                //Check to see if you can "slide" up the rest of the tree.
                if(temp.getLeftChild() == null)
                {
                    if(node == this.root)
                    {
                        this.root = temp;
                    }
                    temp.setLeftChild(node.getLeftChild());
                    temp.setParent(node.getParent());
                    //Connect Parent to Child
                    if(temp.getParent() != null && temp.getParent().getLeftChild() == temp)
                    {
                        temp.getParent().setLeftChild(temp.getRightChild());
                    }
                    if(temp.getParent() != null && temp.getParent().getRightChild() == temp)
                    {
                        temp.getParent().setRightChild(temp.getRightChild());
                    }
                    node.setParent(null);
                    node.setLeftChild(null);
                    node.setRightChild(null);
                    size--;
                    return true;
                }
                while(temp.getLeftChild() != null)
                {
                    temp = temp.getLeftChild();
                }
                //Check for other children to prevent orphaning them.
                if(temp.getRightChild() != null)
                {
                    temp.getRightChild().setParent(temp.getParent());
                    //Connect Parent to Child
                    if(temp.getParent() != null && temp.getParent().getLeftChild() == temp)
                    {
                        temp.getParent().setLeftChild(temp.getRightChild());
                    }
                    if(temp.getParent() != null && temp.getParent().getRightChild() == temp)
                    {
                        temp.getParent().setRightChild(temp.getRightChild());
                    }
                }
            }
            else
            {
                temp = temp.getLeftChild();
                //Check to see if you can "slide" up the rest of the tree.
                if(temp.getRightChild() == null)
                {
                    if(node == this.root)
                    {
                        this.root = temp;
                    }
                    temp.setRightChild(node.getRightChild());
                    temp.setParent(node.getParent());
                    //Connect parent to child
                    if(temp.getParent() != null && temp.getParent().getLeftChild() == temp)
                    {
                        temp.getParent().setLeftChild(temp.getRightChild());
                    }
                    if(temp.getParent() != null && temp.getParent().getRightChild() == temp)
                    {
                        temp.getParent().setRightChild(temp.getRightChild());
                    }
                    node.setParent(null);
                    node.setLeftChild(null);
                    node.setRightChild(null);
                    size--;
                    return true;
                }
                while(temp.getRightChild() != null)
                {
                    temp = temp.getRightChild();
                }
                if(temp.getLeftChild() != null)
                {
                    temp.getLeftChild().setParent(temp.getParent());
                    //connect parent to child
                    if(temp.getParent() != null && temp.getParent().getLeftChild() == temp)
                    {
                        temp.getParent().setLeftChild(temp.getLeftChild());
                    }
                    if(temp.getParent() != null && temp.getParent().getRightChild() == temp)
                    {
                        temp.getParent().setRightChild(temp.getLeftChild());
                    }
                }
            }
            if(node == this.root)
            {
                this.root = temp;
            }
            temp.setLeftChild(node.getLeftChild());
            temp.setRightChild(node.getRightChild());
            temp.setParent(node.getParent());
            //Connect parent to child in the deleted place
            if(node.getParent() != null && node.getParent().getLeftChild() == node)
            {
                node.getParent().setLeftChild(temp);
            }
            if(node.getParent() != null && node.getParent().getRightChild() == node)
            {
                node.getParent().setRightChild(temp);
            }
        }
        else
        {
            //This is if it is a leaf. Null the parent child relationship out
            if(node.getParent() != null && node.getParent().getLeftChild() == node)
            {
                node.getParent().setLeftChild(null);
            }
            if(node.getParent() != null && node.getParent().getRightChild() == node)
            {
                node.getParent().setRightChild(null);
            }
        }
        
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
        if(node == null)
        {
            return null;
        }
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
        if(node == null)
        {
            return;
        }
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
