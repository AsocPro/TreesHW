/*
 * Name: Zachary Pratt 
 * Assignment: Trees
 * Date: 15 April 2013
 * File: Student.java
 * 
 * Description: This is the Student Class to represent a student for the database
 */
package StudentDatabase;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author Zachary Pratt Gibbs
 */
public class Student implements Comparable<Student>, Serializable
{
    int number;
    String lastName, firstName, major;
    double gpa;
    /**
     * Contructor to define Student basics.
     * @param num Student Number
     * @param last Last Name
     * @param first First Name
     */
    public Student(int num, String last, String first)
    {
        this.number = num;
        this.lastName = last;
        this.firstName = first;
        this.major = "Undelcared";
        this.gpa = -1;
    }
    /**
     * Constructor to define all student elements
     * @param num Student Number
     * @param last Last Name
     * @param first First Name
     * @param major Major
     * @param gpa GPA
     */
    public Student(int num, String last, String first, String major, double gpa)
    {
        this.number = num;
        this.lastName = last;
        this.firstName = first;
        this.major = major;
        this.gpa = gpa;
    }

    public int getNumber() 
    {
        return number;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public String getFirstName() 
    {
        return firstName;
    }
    public String getMajor() 
    {
        return major;
    }

    public void setMajor(String major) 
    {
        this.major = major;
    }

    public double getGpa() 
    {
        return gpa;
    }

    public void setGpa(double gpa) 
    {
        this.gpa = gpa;
    }
    @Override
    public int compareTo(Student stu)
    {
        if(this.getNumber() == stu.getNumber())
        {
            return 0;
        }
        else if(this.getNumber() > stu.getNumber())
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
        {
            return false;
        }
        if(obj.getClass() != Student.class)
        {
            return false;
        }
        Student stu = (Student)obj;
        if(this.compareTo(stu) == 0)
        {
            return true;
        }
        return false;
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.number;
        hash = 53 * hash + this.lastName.hashCode();
        hash = 53 * hash + this.firstName.hashCode();
        hash = 53 * hash + this.major.hashCode();
        hash = 53 * hash + (int)(this.gpa*100);
        return hash;
    }
    @Override
    public String toString()
    {
        return this.number + "\t" + this.lastName + ", " + this.firstName
                + "\t" + this.major + "\t"
                + new DecimalFormat("0.00").format(this.gpa);
    }
}
