/**
 *
 * @author Nil
 */
import java.net.*;
import java.io.*;
import java.util.*;
public class carServer {
public static void main(String[] args){
	
	car[] raceCar = new car[5]; //creates an empty array of the type car with 5 cars.
	for (int i=0;i<raceCar.length;i++)//populates the array with cars that have 50 mpg
		raceCar[i] =new car(50);
	
	
	
	try{ 
		ServerSocket sock = new ServerSocket(6013);//opens socket for communication
		while(true){//sets up infinite loop
			Socket client = sock.accept(); //socket accepts packets from client 
			InputStream inStream = client.getInputStream(); //sets up InputStream and OutputStream to send and recieve packets with scanner and printwriter
			OutputStream outStream = client.getOutputStream();
			Scanner in = new Scanner(inStream);
			PrintWriter out = new PrintWriter(outStream); 
			
			String action = in.next();//User will have entered either Get Gas CarNumber, Add Gas CarNumber Gallons, Drive CarNumber Miles
			String k = in.next();
                        int c;
			if (k.equalsIgnoreCase("gas")) //checks to see if second word is gas
				{c = in.nextInt(); //if the second word was gas the third entry should be the car number
				action = action +" "+ k;} //combines first word with gas
                        else
				c = Integer.parseInt(k);// takes int from string
	
			double amount;
			
		if (action.equalsIgnoreCase("Drive")||action.equalsIgnoreCase("Add Gas")||action.equalsIgnoreCase("Get Gas"))	
			{if (action.equalsIgnoreCase("Drive"))//set amount if drive or add gas only becuase get gas wouldn't have an amount
				{amount = in.nextDouble();
                                out.print("Car " + c + " " + raceCar[c-1].drive(amount));}//cars are stored 0-4
			if (action.equalsIgnoreCase("add Gas"))
				{amount = in.nextDouble();
                                out.print(raceCar[c-1].addGas(amount)+ " gallons in car " + c);}
                        if (action.equalsIgnoreCase("Get Gas"))
				out.print("Car " + c + " has " + raceCar[c-1].getGas() + " gallons of gas");
				}
		else 
			out.print("Invalid Entry");
		out.flush();	//flushes out result
		client.close();	}}
	
	catch(IOException ioe){
		System.err.println(ioe);
	}
}
}
