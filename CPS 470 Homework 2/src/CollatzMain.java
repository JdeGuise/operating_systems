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
//		Process pc = Runtime.getRuntime().exec("fork()");
//		BufferedReader in = new BufferedReader(new InputStreamReader(pc.getInputStream()));
        ProcessBuilder pb = null;
        pb.start();
		
		long one = System.currentTimeMillis();
		
		collatzComp(choice);
		
		long two = System.currentTimeMillis();
		
		long three = two - one;
		System.out.println(three + "ms to perform calculations.");
		input.close();
	}
	
	
	public static void collatzComp(int args){
		
		//Collatz conjecture
		while(args != 1){
			if(args % 2 == 0){
				System.out.println("Args is " + args + " (even); dividing by 2");
				args /= 2;
			}
			else{
				System.out.println("Args is " + args + " (odd); multiplying by 3 and adding 1");
				args = (3 * args) + 1;
			}
		}
		System.out.println("Args is " + args + ". Done.");
	}
	

}
