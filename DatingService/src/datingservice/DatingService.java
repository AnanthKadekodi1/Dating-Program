/**
 * Name: DatingService 
 * Date: 14/4/18
 * File: DatingService.java
 * 
 * Purpose: An object class that stores primitive values pertaining to a DatingService class,
 * the values it can store are, Strings relating to customer; gender, loginID and advertisement text
 * Age, income are stored as int
 * This is a dating program that creates the profile of the customers (advertiser and responder), creates advertisements,
 * allows customers to send messages between each other. Customers can be added, deleted and listed. 
 *
 * 
 * Inputs are: 
 * LoginID: String
 * Gender: String
 * Age: int
 * Income: int
 * Range of age desired in partner: int
 * Range of income desired in partner: int
 * Advertisement of partner: string
 * Text message reply: string
 *
 * Output: 
 * List of advertisers
 * List of responders
 * Match received for responder
 * Text message reply received for responder and advertiser
 * Delete a particular customer
 * @author Ananth Kadekodi <32920719> - External - Tutor: Ferdous Sohel
 */

package datingservice;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Main method of program
 * @author Ananth
 */
public class DatingService {

	public static void main(String[] args) {
		
		Scanner keyBoard = new Scanner(System.in);
		DatingServiceImpl datingService = new DatingServiceImpl();
		datingService.initialize();
		
		boolean isExitMain = false;
		// Not exited from the menu
		while(!isExitMain)
		{
			displayMainMenu();
			int menu=0 ;
                        // An error is display if the input value at menu is not an integer
			try
			{
				menu = Integer.parseInt(keyBoard.nextLine());
			}
			catch(Exception e)
			{
				
				System.out.println("The menu should be integer");
				continue;
			}
			// If values inputted > 6 and <1 then program exits
			if(menu>6 || menu<1)
			{
				System.out.println("Invalid option. Please try again!");
				
			}
			else
			{
                                // Start of switch case
				switch(menu)
				{
                                    //Case 1 " Record details of responder and advertiser
				case 1:
					System.out.println("Type R or r for new responder, A or a for Advertiser");
					String type = keyBoard.nextLine().trim();
					
					System.out.println("Enter age: ");
					int age = -1;
					
					try
					{
						age = Integer.parseInt(keyBoard.nextLine());
					}
					catch(Exception e)
					{
						System.out.println("The age should be integer");
						break;
					}
					
					System.out.println("Enter income: ");
					
					int income=0;
					try
					{
						income = Integer.parseInt(keyBoard.nextLine());

					}
					catch(Exception e)
					{
						System.out.println("The income should be integer");
						break;
					}
					
					
					
					System.out.println("Enter loginID: ");
					String loginID = keyBoard.nextLine();
					
					System.out.println("Enter gender: ");
					String gender = keyBoard.nextLine();
					
					// If responder then added to Arraylist
					if(type.toUpperCase().equals("R"))
					{
						Responder responder = new Responder(gender,age,income,loginID);
						datingService.addCustomer(responder);
					}
					else if(type.toUpperCase().equals("A"))
					{
                                                //If Customer then insert Advertisement details
						System.out.println("Enter advert text: ");
						String textAdvert = keyBoard.nextLine();
						
					
						
						System.out.println("Enter partner desciprition data");
						System.out.println("Enter partner gender");
						String partnerGender =  keyBoard.nextLine();
						System.out.println("Enter partner minimum age");
						
						int minAge = 0;
                                                
                                                // Try and catch ensuring that the age is an integer
						try
						{
							minAge = Integer.parseInt(keyBoard.nextLine());
						}
						catch(Exception e)
						{
							System.out.println("The minAge should be integer");
							break;
						}
						
						System.out.println("Enter partner maximum age");
						
                                                //Try catch method to ensure that the max age is an integer
						int maxAge = 0;
						try
						{
							maxAge = Integer.parseInt(keyBoard.nextLine());
						}
						catch(Exception e)
						{
							System.out.println("The maxAge should be integer");
							break;
						}
						
						System.out.println("Enter partner minimum income");
						
						int minIncome = 0;
                                                
                                                //Try catch method ensure that the minimum income is an integer
						try
						{
							minIncome = Integer.parseInt(keyBoard.nextLine());
						}
						catch(Exception e)
						{
							System.out.println("The minIncome should be integer");
							break;
						}
						
						System.out.println("Enter partner maximum income");
						
						int maxIncome = 0;
                                                
                                                //Try and catch method to ensure that the maximum income is an integer
						try
						{
							maxIncome = Integer.parseInt(keyBoard.nextLine());
						}
						catch(Exception e)
						{
							System.out.println("The maxIncome should be integer");
							break;
						}
						
						
						// Create new objects of partner and advertiser and add to arrayList
						PartnerDescription partner = new PartnerDescription(partnerGender,minAge,maxAge,minIncome,maxIncome);
						Advertiser advertiser = new Advertiser(gender,age,income,loginID,textAdvert,partner);
						datingService.addCustomer(advertiser);
					}
					
					Comparator<Customer> NAME = new Comparator<Customer>() {
			            
                                    // Method to compare the loginID of two customers to ensure 
                                    // that  it is not repeated
			            public int compare(Customer o1, Customer o2)
                                    {
			                return o1.getLoginID().compareTo(o2.getLoginID());
			            }
			        };
			        
					datingService.getCustomers().sort(NAME);
					break;
					
                                // Begining of Switch  Case 2        
				case 2:
					System.out.println("Login Advertiser");
					System.out.println("Enter loginID");
					String login = keyBoard.nextLine();
					System.out.println("Enter password");
					String password = keyBoard.nextLine();
					
					Advertiser advertiserCurrent=null; 
					
                                        // Check the loginID and password for the advertiser
					for(Advertiser advertiser : datingService.getAllAdvertisers())
					{
						if(advertiser.getLoginID().equals(login) && advertiser.getPassword().equals(password))
						{
							advertiserCurrent=advertiser;break;
						}
					}
					
                                        //If advertiser does not exist then loginID is stated as NULL
					if(advertiserCurrent==null)
						System.out.println("Invalid login ID");
					else
					{
                                                // Display the reply messages to the advertiser
						System.out.println("All reply messages for " + advertiserCurrent.getLoginID());
						
						int isRemove[] = new int[advertiserCurrent.getReplyMessages().size()];
						int index=0;
						for(Message message : advertiserCurrent.getReplyMessages())
						{
							System.out.println(message);
							
                                                        // Option provided to the user for deleting the message
							System.out.println("Do you want to delete the above message? If so, press Y. If not press N");
							String option = keyBoard.nextLine().toLowerCase().trim();
							
                                                        // If the message is to be deleted then it is removed from the array index
							if(option.equals("y")) isRemove[index]=1;
							index++;
						}
						
                                                // Removed the number of reply messages
						for(int i=advertiserCurrent.getReplyMessages().size()-1; i>=0;i--)
							if(isRemove[i]==1) advertiserCurrent.getReplyMessages().remove(i);
						
					}
					
					break;
                                        
                                // Beginning of Switch Case 3. Responder login
				case 3:
					
					System.out.println("Login Responder");
					System.out.println("Enter loginID");
					String loginResponder = keyBoard.nextLine();
					System.out.println("Enter password");
					String passwordResponder = keyBoard.nextLine();
					
					Responder responderCurrent=null; 
					
                                        
                                        // LoginID and password for Responder is correct
					for(Responder responder : datingService.getAllResponders())
					{
						if(responder.getLoginID().equals(loginResponder) && responder.getPassword().equals(passwordResponder))
						{
							responderCurrent=responder;break;
						}
					}
					
                                        //If responderID is not current then error is displayed
					if(responderCurrent==null)
						System.out.println("Invalid login ID or Password");
					else
					{
						for(Advertiser advertiser : datingService.getAllAdvertisers())
						{
                                                        //If responder matches the advertiser's partner requirements of age, income and gender
                                                        // The responder can can reply to the advertisement
							if(advertiser.getPartnerDecription().isMatching(responderCurrent.getAge(), responderCurrent.getIncome(),responderCurrent.getGender()))
							{
								System.out.println("There is a match advertisement for you!");
								System.out.println("The ad is \"" + advertiser.getTextAdvert() + "\" from " + advertiser.getLoginID());
								System.out.println("Do you want to reply for above advertisement ? If so, press Y and enter");
								String option = keyBoard.nextLine().toLowerCase().trim();
								
								if(option.equals("y"))
								{
									System.out.println("Enter your response");
									String message = keyBoard.nextLine();
									
									Message replyMessage = new Message(responderCurrent,message);
									advertiser.getReplyMessages().add(replyMessage);
								}
							
							}
						}
					}
					
					
					break;
                                        
                                // Beginning of switch case 4. Printing out a list of all advertisers
				case 4:
					printEmptyLine();
					System.out.println("List of all advertisers");
					printEmptyLine();
					
                                        // No advertisers are present
					if(datingService.getAllAdvertisers().size()==0) System.out.println("There are no advertisers!");
					
                                        // Loop through the list of advertisers in the array list
					for(Advertiser advertiser : datingService.getAllAdvertisers())
					{
						System.out.println(advertiser.toString());
					}
					
					printEmptyLine();
					
					break;
                                        
                                //Switch case 5. Display the list of all responders
				case 5:
					printEmptyLine();
					System.out.println("List of all responders");
					
					printEmptyLine();
                                        // If the size of the arrayList == 0 
					if(datingService.getAllResponders().size()==0) System.out.println("There are no responders!");
                                        
                                        //Search through arrayList and displayResponders
					for(Responder responder : datingService.getAllResponders())
					{
						System.out.println(responder.toString());
					}
					
					printEmptyLine();
					
					break;
				//Case 6. List all customers	
				case 6:
					
					printEmptyLine();
					System.out.println("List of all customers");
					printEmptyLine();
					int count=1;
                                        
                                        // For loop to display all the customers
					for(Customer c : datingService.getCustomers())
					{
						System.out.println(count + ". " +c);
						count++;
					}
					
					printEmptyLine();
					System.out.println("Enter the number to delete");
					
					int delete = -1;
					
                                        // Try catch method to ensure that the number to be deleted is an integer
					try
					{
						delete = Integer.parseInt(keyBoard.nextLine());
					}
					catch(Exception e)
					{
						System.out.println("The delete number should be integer");
						break;
					}
                                        
                                        //If a number not present in the list is asked to be deleted. Error message provided. 
					if(datingService.getCustomers().size()>=delete && delete>0)
						datingService.getCustomers().remove(delete-1);
					else
						System.out.println("Invalid number entered! The customer is not removed");
					
					break;
					
				}
			}
			
		}
		

	}

        
        /**
         * Prints out the menu condition
         * Pre-condition: None
         * Post-condition: Displays the menu options
         */
	private static void displayMainMenu() 
	{
	
                printEmptyLine();
                displayStudentDetails();
		printEmptyLine();
		System.out.println("1. Add New Customer");
		System.out.println("2. Login Advertiser");
		System.out.println("3. Login Responder");
		System.out.println("4. Display All Advertisers");
		System.out.println("5. Display All Responders");
		System.out.println("6. Remove a Customer");
		
		printEmptyLine();
		
	}

        //Print out the empty line after the list
	private static void printEmptyLine() 
        {
		System.out.println("------------------------------------------------------------");
	}
	
        //Function to display the student details
        private static void displayStudentDetails()
        {
            System.out.println("Ananth Kadekodi");
            System.out.println("32920719");
            System.out.println("External enrolment");
            System.out.println("Tutor: Ferdous Sohel");
        }
	

}
