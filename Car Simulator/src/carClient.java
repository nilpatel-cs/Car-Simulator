/**
 *
 * @author Nil
 */
import java.net.*;
import java.io.*;
import java.util.*;

public class carClient {
public static void main(String[] args){

try { Socket sock = new Socket("127.0.0.1",6013);
//opens up for communication
InputStream instream = sock.getInputStream();
OutputStream outstream = sock.getOutputStream();
Scanner in = new Scanner(instream);
PrintWriter out = new PrintWriter(outstream);
Scanner key = new Scanner(System.in);


//sets up the outstream, instream, printwriter and scanners
System.out.println("Enter action car and amount (If applicable), ex: Drive 2 20, Get Gas 1");
System.out.println("Actions are Get Gas, Drive and Add Gas. Cars are 1 - 5 ");
String input = key.nextLine(); //takes next line from user
out.println(input); //prepares line to send to the server
out.flush();//sends out line

while (in.hasNextLine())//takes responses and prints them out until no lines are left
{
	String line = in.nextLine();
	System.out.println(line);
}
sock.close();
}
catch (IOException ioe){
System.err.println(ioe);
}
}}
