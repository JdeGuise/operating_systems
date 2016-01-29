import java.awt.List;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;
public class CollatzMain {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		int choice = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter one integer as input");
		
		try{
			choice = input.nextInt();
			getPID();

			String[] command = {"bash", "fork()", Integer.toString(choice)};
	        Process p = Runtime.getRuntime().exec(command);
			long one = System.currentTimeMillis();
			CollatzCalcs.collatzComp(choice);			
			long two = System.currentTimeMillis();
			long three = two - one;
			System.out.println(three + "ms to perform calculations.");
			input.close();
		}
		
		catch(InputMismatchException ime){
			ime.printStackTrace();
		}
	}
	
    public static String getPID() throws IOException, InterruptedException{
    	Vector<String> commands = new Vector<String>();
    	
    	commands.add("/bin/bash");
    	commands.add("-c");
    	commands.add("echo $PPID");
    	ProcessBuilder pb = new ProcessBuilder(commands);
    	
    	Process pr = pb.start();
    	pr.waitFor();
    	
    	if(pr.exitValue() == 0){
    		BufferedReader outReader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
    		return outReader.readLine().trim();
    	}
    	else{
    		System.out.println("Error while getting PID");
    		return "";
    	}
    }
	
	
	
	

}
