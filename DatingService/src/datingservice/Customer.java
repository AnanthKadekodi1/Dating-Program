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
 * Customer Class that sets the age, income, gender, loginID and password of the customer
 */
public class Customer {

	
	// Private variable in integer and strings
	private int age,income;
	private String gender, loginID, password;
	
	/***************************************************************
        Set Section
        *////////////////////////////////////////////////////////////////
        
        /**
         * 
         * @param age
         * @param income
         * @param gender
         * @param loginId 
         */
        
        /**Sets the age, income, gender, loginID and password of the customer,
         * 
         * @param age
         * @param income
         * @param gender
         * @param loginId 
         */
	public Customer(int age, int income, String gender, String loginId)
	{
		this.setAge(age);
		this.setIncome(income);
		this.setGender(gender);
		this.setLoginID(loginId);
		this.setPassword("default123");
	}

        /**Sets age as integer
         * 
         * @param age 
         */
	public void setAge(int age) 
        {
		this.age = age;
	}
           
        /**Sets income as integer
         * 
         * @param income 
         */
	public void setIncome(int income) 
        {
		this.income = income;
	}
        
        /**Returns age as integer
         * 
         * @return 
         */
	public int getAge()
        {
		return age;
	}
        
     
        /**Return income as integer
         * 
         * @return 
         */
	public int getIncome() 
        {
		return income;
	}

        
        /**Returns gender as integer
         * 
         * @return 
         */
	public String getGender() 
        {
		return gender;
	}
        
        /**
         * Set gender as string and lowercases the string 
         */
	public void setGender(String gender) 
        {
		
	gender=gender.toLowerCase();
		
        if (gender.equals(gender))
            this.gender=gender;
        else if(gender.equals("m") || gender.equals("male"))
			this.gender = "male";
        else if (gender.equals("f") || gender.equals("female"))
			this.gender = "female";
	
	}
        
         /**Set password as string
          * 
          * @param password 
          */
	public void setPassword(String password)
        {
		this.password = password;
	}
	
        /******************************************************************         *
         * Get Section
         *////////////////////////////////////////////////////////////////
        
        
        /**Return loginID as string
         * 
         * @return 
         */
	public String getLoginID()
        {
		return loginID;
	}
        
        /**Set loginID as string
         * 
         * @param loginID 
         */
	public void setLoginID(String loginID) 
        {
		this.loginID = loginID;
	}
        
        /**Return password as string
         * 
         * @return 
         */
	public String getPassword()
        {
		return password;
	}
        
}
