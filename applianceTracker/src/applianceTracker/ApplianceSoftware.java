package applianceTracker;

//----------------------------------
//Name: Adrienne Digo
//COMP 249
//Part 2
//----------------------------------

/* This program aids the user to acquire and keep track of appliances at the store. The information that the
* appliances hold, are: serial number, brand, type, and price. With the correct password, the user
* has the ability to enter new appliances and change specific information about them. In addition, this program displays 
* all appliances by a specific brand as well as appliances that are under a certain price. Along with this is an option to 
* "quit" which ends the program with a message.   
*/

/**
* 
* @author Adrienne Digo 
* @version 1.0
* @see Appliance
* 
*/

import java.util.Scanner;

public class ApplianceSoftware {
	
	public static void main(String[] args) {
		int size = 0;
		// Welcome Message
		String border = "*-----------------------------------*";
		System.out.println(border);
		System.out.println("*Adrienne Digo's Appliance Inventory*");
		System.out.println(border);
		System.out.println();

		// Declaring our scanner
		Scanner key = new Scanner(System.in);

		System.out.print("Please enter the maximum number of appliances: ");

		// Reading user input
		int maxNum = key.nextInt();

		System.out.println("");

		Appliance inventory[] = new Appliance[maxNum];

		int choice = 1;
		int passwordAttempt = 0;
		while (choice != 5 && passwordAttempt < 12) {
			//Main Menu
			System.out.println("What do you want to do?");
			System.out.println("\t" + "1.   Enter new appliances (password required)");
			System.out.println("\t" + "2.   Change information of an appliance (password required)");
			System.out.println("\t" + "3.   Display all appliances by a specific brand");
			System.out.println("\t" + "4.   Display all appliances under a certian price");
			System.out.println("\t" + "5.   Quit");
			System.out.print("Please enter your choice> ");

			choice = key.nextInt();

			System.out.println();

			loop: switch (choice) {	//switch statement to allow for multi-way selection based on main menu
			case 1:
				do {
					String password;
					System.out.print("Please enter your password: ");
					password = key.next();

					if (Appliance.verifyPassword(password) == 1) {	//calls verifyPassword() method which returns a 1 (if password is correct) or 0 (if password is incorrect)
						passwordAttempt = 0;
						int numAppliance = 0;

						System.out.print("\nHow many appliances do you want to enter? ");
						numAppliance = key.nextInt();
						if (maxNum - size >= numAppliance) {	// size refers to the space taken in the array
							for (int i = 0; i < numAppliance; i++) {
								System.out.println("Please enter the information for appliance #" + (i + 1) + "\n");
								inventory[i] = new Appliance();

								boolean invalid = true;
								while (invalid) {
									System.out.print("Serial Number: ");
									long updatedSerialNum = key.nextLong();
									if (Appliance.verifySerialNumber(updatedSerialNum) == false) {		//calls the verifySerialNumber() method to verify if conditions are satisfied
										System.out.println("Invalid type. Please enter an appropriate type.\n");
									} else {
										inventory[i].setSerialNumber(updatedSerialNum);
										invalid = false;
									}
								}
								System.out.print("Appliance Brand: ");	// no need to call a verifyBrand method as there are no conditions for this String type
								String updatedBrand = key.next();
								inventory[i].setBrand(updatedBrand);

								boolean invalid2 = true;
								while (invalid2) {
									System.out.print("Appliance Type: ");
									String updatedType = key.next();
									if (Appliance.verifyType(updatedType) == false) {	//calls the verifyType() method to verify if conditions are satisfied
										System.out.println("Invalid type. Please enter an appropriate type.\n");
									} else {
										inventory[i].setType(updatedType);
										invalid2 = false;
									}
								}

								boolean invalid3 = true;
								while (invalid3) {
									System.out.print("Appliance Price: \n");
									double updatedPrice = key.nextDouble();
									if (Appliance.verifyPrice(updatedPrice) == false) {		//calls the verifyType() method to verify if conditions are satisfied
										System.out.println("Invalid price. Please enter an appropriate price.\n");
									} else {
										inventory[i].setPrice(updatedPrice);
										invalid3 = false;
									}
								}
								size++;	
							}
						} else {
							System.out.print("There is not enough space. You only have space for " + (maxNum - size)
									+ " more new appliance(s).\n\n");

						}
						break;
					} else {
						passwordAttempt++;
					}
				} while (passwordAttempt % 3 != 0);	//password attempts are in multiples of 3
				break;

			case 2:
				do {
					String password;
					System.out.print("Please enter your password: ");
					password = key.next();

					if (Appliance.verifyPassword(password) == 1) {
						passwordAttempt = 0;
						//The bulk of comments below are a code that allows to verify if the entered serial number already exists. 
						//If it does not, a message will be displayed and asked if they would like to go back to the main menu or try
						//again. Program terminates when you chose to try again.
						/*boolean invalidSerial = true;
						while (invalidSerial = true) {
							System.out.print("Enter the serial number of the appliance you wish to update: \n");
							long serialToChange = key.nextLong();
							int count = Appliance.findSerialNumber(inventory, size, serialToChange);
							if (count == 0) {
								System.out.println("Serial number not found. Would you like to: \n (1) Re-enter " +
										"another serial number? \n(2) Go back to main menu?");
								int answer = key.nextInt();
								switch(answer) {
								case 1: 
									break;
								case 2: 
									break loop;
								default:
									System.out.println("Invalid Input. Select 1 or 2.");
								}
								
							}else 
								invalidSerial = false;*/
						
							System.out.print("Enter the serial number of the appliance you wish to update: \n");
							long serialToChange = key.nextLong();	
							
							Appliance info = new Appliance();
							System.out.println(info);
							
							int index = Appliance.indexSerial(inventory, size, serialToChange);		//finds the index of the array to which the serial number belongs to
							int choice2 = 0;
							if (index >= 0) {		//index of an array begin at 0. index>=0 ensures that the program is within the array
								while (choice2 != 4) {
									System.out.println("What information would you like to change?");
									System.out.println("\t1. Brand \n\t2. Type \n\t3. Price \n\t4. Quit");
									System.out.print("Enter your choice> ");

									choice2 = key.nextInt();

									switch (choice2) {
									case 1:
										System.out.println("Enter brand name: ");
										String updatedBrand = key.next();
										inventory[index].setBrand(updatedBrand); // no verification needed on brand
																					// since it can be any string
										break;

									case 2:
										boolean invalid = true;
										while (invalid) {
											System.out.print("Enter type: ");
											String updatedType = key.next();
											if (Appliance.verifyType(updatedType) == false) {
												System.out.println(
														"Invalid type. Please enter an appropriate type of appliance: ");
											} else {
												inventory[index].setType(updatedType);
												invalid = false;
											}

										}

										break;

									case 3:
										boolean invalid1 = true;
										while (invalid1) {
											System.out.print("Enter price: ");
											double updatedPrice = key.nextDouble();
											if (Appliance.verifyPrice(updatedPrice) == false) {
												System.out
														.println("Invalid price. Please enter an appropriate price: ");

											} else {
												inventory[index].setPrice(updatedPrice);
												invalid1 = false;
											}
										}

										break;

									case 4:
										break loop;	//leaves defined loop and goes back to main menu

									default:
										System.out.println("Invalid input Select again.");

									}
									{

									}
								}

							} else
								System.out.println("\nThis serial Number does not exist.\n");	
						}
					

					else
						passwordAttempt++;

				} while (passwordAttempt % 3 != 0);		//password attempts are in multiples of three

			case 3:
				System.out.print("Enter a Brand name: ");
				String newBrand = key.next();

				System.out.println("All appliances under " + newBrand + "\n");
				Appliance.applianceBrand(inventory, size, newBrand);
				break;

			case 4:
				System.out.println("Enter a price: ");
				double p = key.nextDouble();

				System.out.println("All appliances under $" + p + "\n");
				Appliance.findCheaperThan(inventory, size, p);
				break;

			case 5:
				System.out.println("*--------------------------------------------------------*");
				System.out.println("Thank you for using Adrienne Digo's Appliance Inventory");
				System.out.println("*--------------------------------------------------------*");
				break;
			}
			if (passwordAttempt >= 12) {
				System.out.println("Program detected suspicious activities and will terminate immediately!");
				System.exit(0); // Termination of program
			}
		}
		//closing scanner
		key.close();
	}
}