/*
 * Name: Zachary Pratt 
 * Assignment: Trees
 * Date: 17 April 2013
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
    /**
     * Get the Student number
     * @return The Student Number
     */
    public int getNumber() 
    {
        return number;
    }
    /**
     * Get the student's last name
     * @return Last name of the student
     */
    public String getLastName() 
    {
        return lastName;
    }
    /**
     * get the student's first name
     * @return First name of the student
     */
    public String getFirstName() 
    {
        return firstName;
    }
    /**
     * Get the student's major
     * @return Major of the student
     */
    public String getMajor() 
    {
        return major;
    }
    /**
     * Set the major of the student
     * @param major Major to set.
     */
    public void setMajor(String major) 
    {
        this.major = major;
    }
    /**
     * Get the GPA of the student
     * @return GPA of the student
     */
    public double getGpa() 
    {
        return gpa;
    }
    /**
     * set the GPA of the student
     * @param gpa of the student
     */
    public void setGpa(double gpa) 
    {
        this.gpa = gpa;
    }
    /**
     * method to compare a student based on their student number
     * @param stu Student to compare to
     * @return -1 if the student number is less than the parameter, 1 if it is greater and 0 if they are the same
     */
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
    /**
     * Override equals based on the student number.
     * @param obj object to compare
     * @return true if the student numbers are the same false if they are not
     */
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
    /**
     * hashCode overridden for a student
     * @return student hashcode
     */
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
    /**
     * Override of the toString method
     * @return String based student including the number, name, major and gpa
     */
    @Override
    public String toString()
    {
        return this.number + "\t" + this.lastName + ", " + this.firstName
                + "\t" + this.major + "\t"
                + new DecimalFormat("0.00").format(this.gpa);
    }
}
