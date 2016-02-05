import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class CollatzMain {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter one integer as input");

		
		
		Thread pthread = new Thread(){
				public void run(){
					int choice = 0;

					try{
						
						choice = input.nextInt();
						
					}
					catch(InputMismatchException ime){
						ime.printStackTrace();
					}
					
					long one = System.currentTimeMillis();

					collatzComp(choice);

					long two = System.currentTimeMillis();
					System.out.println("Methods took " + (two-one) + "ms to complete.");
					
				}
				
		};
			System.out.println("Starting");
			pthread.start();
			System.out.println("Finished.");
			
			synchronized(pthread){
				System.out.println("Before Wait");
				pthread.wait();
			}		
			input.close();
	}
	
	public static void collatzComp(int args){
		System.out.println("Enter your argument");
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
		System.out.println("Args is " + args + "; Done.");
	}

}
