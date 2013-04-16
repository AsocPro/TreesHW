/*
 * Name: Zachary Pratt 
 * Assignment: Trees
 * Date: 15 April 2013
 * File: SerialVisitorOut.java
 * 
 * Description: This is a Visitor used in the serialization of a BinarySearchTree.
 */
package bst;

import java.io.*;

/**
 *
 * @author Zachary Pratt Gibbs
 */
public class SerialVisitorOut<E extends Comparable<E>> implements Visitor<E>
{
    ObjectOutput out;
    /**
     * Constructor
     * @param filename name of the file to write out to
     * @throws IOException If something goes wrong in the write
     */
    public SerialVisitorOut(String filename, int size) throws IOException
    {
        out = new ObjectOutputStream(new FileOutputStream(filename));
        out.writeInt(size);
    }
    @Override
    public void visit(BSTNode<E> node)
    {
        try 
        {
            E element = node.getElement();
            out.writeObject(element);
        } 
        catch (IOException ex) 
        {
            System.out.println("Write Error");
        }
    }
    /**
     * closes the ObjectOutputStream
     * @throws IOException 
     */
    public void close() throws IOException
    {
        out.close();
    }
}
