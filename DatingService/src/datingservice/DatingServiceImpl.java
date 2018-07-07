/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingservice;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ananth
 */


/**
     * This class contains the arraylist for storing the getter and setting values of the dating service customer details. 
     * Pre-condition: takes the input of get values of customers; set values of customers; customers added; customers removed.
     * The advertisers; responders and matching responders from the arrayList are also retrieved
     * Post-condition: The values from the pre-condition are stored in an array list
     * 
     */
public class DatingServiceImpl {
    
    
    private ArrayList<Customer> customers;
	
    
       
        /**
         * arrayList initialised
         */
	public void initialize()
	{
		customers = new ArrayList<Customer>();
	}
    
        
        /**Customer added to arrayList
         * 
         * @param customer 
         */
	public void addCustomer(Customer customer)
	{
		customers.add(customer);
	}
        
        /**
         * Customer removed from arrayList
         */
	public void removeCustomer(Customer customer)
	{
		customers.remove(customer);
	}
	
    
        
        /****************************************************
        * Set Section
        *//////////////////////////////////////////////////////
        
        /**Set values of customers added in ArrayList
         * 
         * @param customers 
         */
	public void setCustomers(ArrayList<Customer> customers) 
        {
		this.customers = customers;
	}

        
        /*****************************************************
        * Get Section 
        *////////////////////////////////////////////////////////
    
	// Get values of customer added in ArrayList
        /**
         * 
         * @return customers
         */
	public ArrayList<Customer> getCustomers() 
        {
		return customers;
	}
        
        /**
         * Get all the advertisers from the arrayList
         */
	public ArrayList<Advertiser> getAllAdvertisers()
	{
		ArrayList<Advertiser> advertisers = new ArrayList<Advertiser>();
		
		for(Customer customer : customers)
		{
			if(customer instanceof Advertiser)
				advertisers.add((Advertiser)customer);
		}
		
		return advertisers;
	}

        /**
         * Get all the responders from the arrayList
         */
	public ArrayList<Responder> getAllResponders()
	{
		ArrayList<Responder> responders = new ArrayList<Responder>();
		
		for(Customer customer : customers)
		{
			if(customer instanceof Responder)
				responders.add((Responder)customer);
		}
		
		return responders;
	}
        
        
         /**
          * Get all the matches for responders from arrayList
          */
	public int getMatchesForResponder(Responder responder)
	{
		Scanner keyBoard = new Scanner(System.in);
		int replyCount=0;
		for(Customer customer : customers)
		{
			if(customer instanceof Advertiser)
			{
				PartnerDescription partner = ((Advertiser) customer).getPartnerDecription();
				
				if(partner.isMatching(responder.getAge(),responder.getIncome(),responder.getGender()))
				{
					System.out.println("You have a match from : " + ((Advertiser)customer).getTextAdvert());
					System.out.println("Enter reply message");
					String response = keyBoard.nextLine().trim();
					
					Message replyMessage = new Message(responder,response);
					((Advertiser)customer).getReplyMessages().add(replyMessage);
					
					replyCount++;
					
				}
			}
				
		}
		
		return replyCount;
		
	}
	
}
