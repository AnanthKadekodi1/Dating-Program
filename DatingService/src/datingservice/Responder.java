/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingservice;

/**
 *
 * @author Ananth
 */


/**
 * Inheritance class as responder is a subclass of Customer and inherits all the fields and methods of customer
 */
public class Responder extends Customer {

	/**Responder inherits the values of gender, age, income and username from the customer values
         * 
         * @param gender
         * @param age
         * @param income
         * @param username 
         */
	public Responder(String gender, int age, int income, String username)
	{
		
            super(age,income,gender,username);
	}

	/**
         * Return the details of the responder as a string. Encompassing age, income and gender
         */
	public String toString() 
        {
		return getLoginID() + " [Age=" + getAge() + ", Income=" + getIncome() + ", Gender=" + getGender() + "]";
				
	}
	
	
	
}
