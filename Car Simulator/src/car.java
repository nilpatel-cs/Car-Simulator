/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nil
 */
public class car //this class will be used to define the object "car"
	{  
		private double gasInTank; //create two instance variables for car one for how much gas it has and one for its mpg
		private double mpg;
		
		/**
		Constructs a car with gas efficiency (miles per gallon).
		*/
		public car(double efficiency) //constructor for car that asks for mpg, defaults the car with no gas in tank.
		{
			mpg = efficiency;
			gasInTank = 0;
			
		}
		
		
		public String addGas(double amount) //method in which a amount is taken to be added into the tank
		{
			gasInTank = gasInTank + amount;
                        return "Added " + amount + " gallons, now you have " + gasInTank;
		}
		
		
		public String drive(double miles)//method that thats miles driven and updates the gas left in tank based on gas used
		{
			gasInTank = gasInTank - miles/mpg;
			return "drove " + miles + " miles, now it has " + gasInTank +" gallons in its tank";
		}
		
		
		public double getGas() //method thats can be called to get how much gas is in the car
		{
			return gasInTank;
		
		}
	
	}
