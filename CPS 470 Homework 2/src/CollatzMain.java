import java.io.*;
import java.net.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class CollatzMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int choice = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter one integer as input");
		try{
			choice = input.nextInt();
		}
		catch(InputMismatchException ime){
			ime.printStackTrace();
		}
		List<V> command = {"bash", choice};

        Process p = new ProcessBuilder(command).start();
		long one = System.currentTimeMillis();
		
		collatzComp(choice);
		
		long two = System.currentTimeMillis();
		
		long three = two - one;
		System.out.println(three + "ms to perform calculations.");
		input.close();
	}
	
	
	
	

}
