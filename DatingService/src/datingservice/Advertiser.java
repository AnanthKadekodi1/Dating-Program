/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingservice;
import java.util.ArrayList;

/**
 * Contains the variables for the advertiser
 * @author Ananth
 */
public class Advertiser extends Customer {

        /**
         * Private variables
         */ 
	private String textAdvert;
	private ArrayList<Message> replyMessages;
	private PartnerDescription partnerDecription;
	
	
	/**
         * Provide string representation of advert, number of messages, partner description, age, income and gender
         */ 
	public String toString() {
		return getLoginID() + " [textAdvert=" + textAdvert + ", replyMessages count=" + replyMessages.size() + ", partnerDecription="
				+ partnerDecription + ", Age=" + getAge() + ", Income=" + getIncome() + ", Gender="
				+ getGender() + "]";
	}

        /** 
         * 
         * @param gender
         * @param age
         * @param income
         * @param username
         * @param textAdvert
         * @param partner 
         */
        
        /**Setter function to set the username, textAdvert, age, income, gender and partner
         * 
         * @param gender
         * @param age
         * @param income
         * @param username
         * @param textAdvert
         * @param partner 
         */
	public Advertiser(String gender, int age, int income, String username, String textAdvert,PartnerDescription partner)
	{
		super(age,income,gender,username);
		this.setReplyMessages(new ArrayList<>());
		this.setTextAdvert(textAdvert);
		this.setPartnerDecription(partner);
	}
	
        
        /********************************************************
         * Set Section
         */////////////////////////////////////////////////////////
        
        //Set textAdvert of type string
	public void setTextAdvert(String textAdvert) 
        {
		this.textAdvert = textAdvert;
	}
        
        /**Set replyMessages into arrayList
         * 
         * @param replyMessages 
         */
	public void setReplyMessages(ArrayList<Message> replyMessages) 
        {
		this.replyMessages = replyMessages;
	}
        
        /**Set partnerDescription Value
         * 
         * @param partnerDecription 
         */
	public void setPartnerDecription(PartnerDescription partnerDecription) 
        {
		this.partnerDecription = partnerDecription;
	}
	
        
        /*******************************************************
         * Get Section       *  
         *//////////////////////////////////////////////////////////
       
	/**
         * Return textAdvert of type string
         */ 
	public String getTextAdvert() 
        {
		return textAdvert;
	}
        
        
        /**Return reply message
         * 
         * @return 
         */
	public ArrayList<Message> getReplyMessages() 
        {
		return replyMessages;
	}
        
      
        /**Return partnerDescription
         * 
         * @return 
         */
	public PartnerDescription getPartnerDecription() 
        {
		return partnerDecription;
	}
        
       
	
}
