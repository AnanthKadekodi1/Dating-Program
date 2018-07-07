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
 * This class has been created to incorporate the message functionality of the program.
 * The class set the owner of the message and sets the message created by the owner. 
 */
public class Message {

        /**
         * private variable encompass the owner of the responder type and message of the string type
         */
	private Responder owner;
	private String message;
	
	/**
         * Return the message in the form of string
         */
	public String toString() 
        {
		return "Message sent by owner " + owner.getLoginID() + " and the message is \"" + message + "\"";
	}
        
        /*******************************************************************
         * Set Function
         *//////////////////////////////////////////////////////////////////
        
        /**
         * 
         * @param responder
         * @param response 
         */
        
        /**
         *Set owner to be the responder and message to be the response
         */
	public Message(Responder responder, String response) 
        {
		this.owner=responder;
		this.message=response;
	}
        
         /**
          * Set the owner
          */
	public void setOwner(Responder owner) 
        {
		this.owner = owner;
	}
        
          /**
           * Sets the message
           */
	public void setMessage(String message) 
        {
		this.message = message;
	}
	
        /*************************************************************
         * Get Section
         *////////////////////////////////////////////////////////////////
        
        /**
         * Returns owner as responder
         */
	public Responder getOwner() 
        {
		return owner;
	}
        
        
        /**
         * Return message as string
         */
	public String getMessage() 
        {
		return message;
	}
        
      
}
