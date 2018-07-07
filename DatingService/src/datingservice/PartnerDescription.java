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
 * 
 * This class has been created to record the description details of the partner
 */
public class PartnerDescription {
    
        //Private variables
	private String gender;
	private int minimunAge, maximumAge, minimumIncome, maximumIncome;

	
	
	//Returns the value recorded by the program in string format
	public String toString() 
        {
		return "[gender=" + gender + ", minimumAge=" + minimunAge + ", maximumAge=" + maximumAge
				+ ", minimumIncome=" + minimumIncome + ", maximumIncome=" + maximumIncome + "]";
	}

        /*************************************************************
         * Set Section
         *///////////////////////////////////////////////////////////////
        
        
        
        
        //Sets the descriptions for the partner
        //Pre-conditions: gender is male or female
        //Minimum age : int of than 0
        // Maximum age : int of less than 120
        // Minimum income  : int of more than 0
        // Maximum income : int of unlimited
        //Post condition: The values are inputted and set
       
        /**
         * 
         * @param gender
         * @param minimunAge
         * @param maximumAge
         * @param minimumIncome
         * @param maximumIncome 
         */
	public PartnerDescription(String gender, int minimunAge, int maximumAge, int minimumIncome, int maximumIncome) 
        {
		super();
		this.gender = gender;
		this.minimunAge = minimunAge;
		this.maximumAge = maximumAge;
		this.minimumIncome = minimumIncome;
		this.maximumIncome = maximumIncome;
	}
	
         /**
          * Set gender as string. Ensure that m and male or f and female are the same
          */
	public void setGender(String gender) 
        {
		gender=gender.toLowerCase();
		
		if(gender.equals("m") || gender.equals("male"))
			this.gender = "male";
		else if(gender.equals("f") || gender.equals("female"))
			this.gender = "female";
		else
			this.gender=gender;
	}
        
         /**
          * Set minimum age 
          *  
          */
	public void setMinimunAge(int minimunAge) 
        {
		this.minimunAge = minimunAge;
	}
        
        /**
         * Set maximum age as int
         */ 
	public void setMaximumAge(int maximumAge) 
        {
		this.maximumAge = maximumAge;
	}
        
        /**
         * Set the minimmum income value
         */
	public void setMinimumIncome(int minimumIncome) 
        {
		this.minimumIncome = minimumIncome;
	}
        
         /**
          *Set maximum income
          */
	public void setMaximumIncome(int maximumIncome) 
        {
		this.maximumIncome = maximumIncome;
	}
        
        /***********************************************************
         * Get Section 
         *//////////////////////////////////////////////////////////
        
        /**
         *Return gender as string
         */
	public String getGender() 
        {
		return gender;
	}
        
      
        
        /**
         * Return minimum age as int
         */
	public int getMinimunAge() {
		return minimunAge;
	}
        
       
        
        /**
         *Return maximum age as int
         * 
         */
	public int getMaximumAge() {
		return maximumAge;
	}
        
       
        /**
         * Return minumum income as int
         */
	public int getMinimumIncome() {
		return minimumIncome;
	}
        
       
        
        /**
         * 
         * Return maximum income as int
         */
	public int getMaximumIncome() {
		return maximumIncome;
	}
        
       
	/**
	*This function checks if the age , income and gender inputted for partner match the responder
        *
        */
	public boolean isMatching(int age, int income, String gender) {
		
		if(this.getMinimunAge()>age || this.getMaximumAge() <age)
			return false;
		
		if(this.getMinimumIncome()>income || this.getMaximumIncome()<income)
			return false;
		
		if(!this.getGender().toLowerCase().equals(gender.toLowerCase()))
			return false;
		
		return true;
	}
	
	
}
