# Appliance-Tracker

## SUMMARY 
This program aids the user to acquire and keep track of appliances at the store. The information that the appliances hold, are: serial number, brand, type, and price. With the correct password, the user has the ability to enter new appliances and change specific information about them. In addition, this program displays  all appliances by a specific brand as well as appliances that are under a certain price. Along with this is an option to "quit" which ends the program with a message. 

## Specifics:
### Part 1
- Appliance object contains four attributes:
  1. Type
      - Fridge, Air Conditioner, Washer, Dryer, Freezer, Stove, Dishwasher, Water Heater, Microwave    
  3. Brand
      -  Indicates the vendor/manufacturer of the appliance and can be any string 
  5. Serial Number
      - Must be at least 1000000
  7. Price
      - Cannot be less than $1

- The design allows enough flexibility so that the value of any of these       attributes can be modified later on. The design also allows the user to
obtain the value of any of the attributes.
- The design allows all information of an object to be displayed at once through the
utilization of System.out.print() and toString() method
- It is required to know how many appliance objects have been created. findNumberOfCreatedAppliances() method returns the number of created appliance objects prior to the time this method is called. The method simply returns 0 if no appliances have been created by the time the method is called.
- equal() method compares two Appliance objects for equaity. Two appliances are
considered equal if they have the same brand, type and price 
- The design displays any Appliance object (all info of that object) using
System.out.println() method

### Part 2
- a main() method will:
  - Display a welcome message;
  - Prompt the store owner for the maximum number of appliances (maxAppliances) his/her
store can contain (or wish to aquire). 
  - Create an empty array, called inventory, that will have the potential of keeping track of the created Appliance objects.
  - Display a main menu with the following choices and keep prompting the user
until they enter a number between 1 and 5 inclusive (i.e invalid number will result in
repeating the display of the main menu)
    1. _Choice 1_
        - Prompt user for password (c249)
          - If invalid:
            - After the 3rd invalid entry, main menu will be redisplayed 
            - A total of 12 consecutive failed attempts, program exists
          - If valid: 
        _   - Prompt user to enter how many appliances he/she wants to enter. Space in array will be verified 
    2. _Choice 2_
        - Prompt user for password (c249)
        - If invalid:
            - After the 3rd invalid entry, main menu will be redisplayed 
        - If valid: 
            -Ask the user of the serial number of the appliance he/she wishes to update.
              - If serial number does not exist, prompt user to reenter or go back to main menu
              - If serial number exists, display appliance information 
            - Continually prompt user for additional changes till user chooses to exit 
    3. _Choice 3_
        - Prompt user for brand name 
        - Appliance information of brand will be displayed 
    4. _Choice 4_
        - Prompt user to enter a price 
        - Information of all appliances in inventory smaller than input will be displayed 
    5. _Choice 5_
        - Displays closing message 
        - Program ends 
    
  


    
  
