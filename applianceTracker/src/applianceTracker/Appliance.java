package applianceTracker;

//----------------------------------
//Name: Adrienne Digo
//COMP 249
//Part 1
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
* @see ApplianceSoftware
* 
*/

import java.util.Scanner;


public class Appliance {
	
	
	private String type;
	private String brand;
	private long serialNumber;
	private double price;

	/**
	 * Default constructor initializes the attributes to its 'zero' value
	 */
	public Appliance() {
		type = "";
		brand = "";
		serialNumber = 1000000;
		price = 1.0;
	}
	
	/**
	 * This method returns the type.
	 * @return Returns string value of type.
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * This method returns the brand.
	 * @return Returns string value of brand.
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * This method returns the serial number.
	 * @return Returns long value of serial number.
	 */
	public long getSerialNumber() {
		return serialNumber;
	}
	
	/**
	 * This method returns the price.
	 * @return Returns double value of price.
	 */
	public double getPrice() {
		return price;
	}
		
	/**
	 * This method sets the type with the passed string value.
	 * @param string value passed to replace the existing type.
	 */
	public void setType(String tp) {
		type = tp;
	}
	
	/**
	 * This method sets the brand with the passed string value.
	 * @param string value passed to replace the existing brand.
	 */
	public void setBrand(String br) {
		brand = br;
	}
	/**
	 * This method sets the serial number with the passed integer value.
	 * @param integer value passed to replace the existing serial number
	 */	
	public void setSerialNumber(long serialNum) {
		serialNumber = serialNum;
	}
	/**
	 * This method sets the price with the passed integer value.
	 * @param integer value passed to replace the existing price
	 */		
	public void setPrice(double p){
		price = p;
	}
	
	/**
	 * This method returns the formatted string displaying the instance variables of the appliance object
	 * @return Returns each instance variable in String form. 
	 * @Override
	 */
	public String toString() {
		return ("\t" + "Applaince Serial # " + getSerialNumber() + "\n" + "\t" + "Brand: " + getBrand() 
				+ "\n" + "\t" + "Type: " + getType() + "\n" + "\t" + "Price: " + getPrice() + "\n");
	}
	
	/**
	 * This method reads array called inventory and scans if there is content in its elements  
	 * @return Returns the number of created appliance objects prior to the time this method is called
	 */
	public int findNumberofCreatedAppliances(int[] inventory){
		int counter = 0;
		for (int i=0 ; i <= inventory.length-1 ; i++) {
			if (inventory[i] == 0)
				break;
			else
				counter++;
		}
			
		return counter + 0;
	}
		
	/**
	 * This method compares appliance objects for equality
	 * @param other object of type Appliance.
	 * @return Returns boolean value by seeing if calling object matches the passed object.
	 */
	public boolean equals(Appliance other) {
		return ((brand == other.brand) && (type == other.type) && (price == other.price));
	}
	
	/** This method assigns the user's value of serial number to its mutator method. 
	 * 
	 * @param inventory 
	 */
	public static void newSerialNumber(Appliance inventory) {
		Scanner key = new Scanner(System.in);
		
		System.out.print("Appliance Serial #: ");
		long newSerialNumber = key.nextLong();
		inventory.setSerialNumber(newSerialNumber);
		key.close();	//closer scanner
	}
	
	/** This method assigns the user's value of brand to its mutator method. 
	 * 
	 * @param inventory 
	 */
	public static void newBrand(Appliance inventory) {
		Scanner key = new Scanner(System.in);
		System.out.print("Brand: ");
		String newBrand = key.next();
		inventory.setBrand(newBrand);
		key.close();	//close scanner
	}
	
	/** This method assigns the user's value of type to its mutator method. 
	 * 
	 * @param inventory 
	 */
	public static void newType(Appliance inventory) {
		Scanner key = new Scanner(System.in);
		System.out.print("Type: ");
		String newType = key.next();
		inventory.setType(newType);
		key.close();	//close scanner
	}
	
	/** This method assigns the user's value of price to its mutator method. 
	 * 
	 * @param inventory 
	 */
	public static void newPrice(Appliance inventory) {
		Scanner key = new Scanner(System.in);	
		System.out.print("Price: ");
		double newPrice = key.nextDouble();
		inventory.setPrice(newPrice);
		key.close();	//close scanner 
	}
		
	
	/**
	 * This method validates input according to set conditions. 
	 * It verifies if the passed object matches to that of the defined strings
	 * @param typeInQuestion of type String 
	 * @return boolean value 
	 */
	public static boolean verifyType(String typeInQuestion) {
				
		String s1 = "Fridge", s2 = "Air Conditioner", s3 = "Washer", s4 = "Dryer", 
				s5 = "Freezer", s6 = "Stove", s7 = "Dishwasher", s8 = "Water Heaters", 
				s9 = "Microwave";
				
		return ((s1.equalsIgnoreCase(typeInQuestion)) || (s2.equalsIgnoreCase(typeInQuestion)) || (s3.equalsIgnoreCase(typeInQuestion)) ||
				(s4.equalsIgnoreCase(typeInQuestion)) || (s5.equalsIgnoreCase(typeInQuestion)) || 
				(s6.equalsIgnoreCase(typeInQuestion)) || (s7.equalsIgnoreCase(typeInQuestion)) || 
				(s8.equalsIgnoreCase(typeInQuestion)) || (s9.equalsIgnoreCase(typeInQuestion))); 	
	}
	
	/**
	 * This method validates input according to set conditions. 
	 * It verifies if the passed object is at least $1.00 
	 * @param priceInQuestion of type double
	 * @return boolean value 
	 */
	public static boolean verifyPrice(double priceInQuestion) {
		double conditionPrice = 1.0;
		return (priceInQuestion >= conditionPrice);
	}
	
	/**
	 * This method validates input according to set conditions. 
	 * It verifies if the passed object is at least 1000000
	 * @param priceInQuestion of type double
	 * @return boolean value 
	 */
	public static boolean verifySerialNumber(long serialInQuestion) {
		long conditionSerial = 1000000;
		return (serialInQuestion >= conditionSerial);
	}
	
	/**
	 * This method scans the array to verify if there is an existing serial number that matches to that of the user's input
	 * @param inventory
	 * @param size
	 * @param serialToChange
	 * @return counter of type integer
	 */
	public static int findSerialNumber(Appliance inventory[], int size, long serialToChange) {
		int counter = 0;
		
		for (int i = 0; i <= size; i++)
		{
			 	if (inventory[i].getSerialNumber() == (serialToChange)) {
				counter++;
			 	}
			 	else 
			 		break;
		}return counter;
	
	
}
	/**
	 * This method verifies the password is correct or incorrect
	 * @param password of type String 
	 * @return an integer of either 1 or 0
	 */
	public static int verifyPassword(String password) {
		String PASSWORD = "c249";
		if (PASSWORD.equals(password)) {
			return 1; 
		}
		System.out.println("Incorrect Password.\n");
		return 0;
	}
	
	
	/**
	 * This method looks at the the information of all appliances in the inventory with the same brand to that of the user input
	 * @param inventory
	 * @param size
	 * @param brand
	 */
	public static void applianceBrand(Appliance inventory[], int size, String brand) {
		for (int i = 0; i < size; i++) {
			if (inventory[i].getBrand().equalsIgnoreCase(brand)) {
				System.out.println("\nSerial Number: " + inventory[i].getSerialNumber() + "  Brand: " + inventory[i].getBrand()
								+ "  Type: " + inventory[i].getType() + "  Price: " + inventory[i].getPrice() + "\n");
			}
		}
	}
	
	/**
	 * This method looks for the appliance(s) that have a price smaller than that of the user's  
	 * @param inventory
	 * @param size
	 * @param price
	 */
	public static void findCheaperThan(Appliance inventory[], int size, double price) {
		for (int i = 0; i < size; i++) {
			if (inventory[i].getPrice() < price) {
				System.out.println(
						"\nSerial Number: " + inventory[i].getSerialNumber() + "\nBrand: " + inventory[i].getBrand()
								+ "\nType: " + inventory[i].getType() + "\nPrice: " + inventory[i].getPrice() + "\t");
			}
		}
	}

	/**
	 *  This method looks for the index to which the serial number the user entered belongs to
	 *  @param inventory
	 *  @param size
	 *  @param serialToChange
	 *  @return i
	 */
	public static int indexSerial(Appliance inventory[], int size, long serialToChange) {
		int i = 0;
		while (i <= size) {
			if (inventory[i].getSerialNumber() == (serialToChange)) {
				return i;
			}
			i++;
		}
		return i;
	}
	
}

