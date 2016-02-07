import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class CollatzMain {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner input = new Scanner(System.in);

		
		Thread pthread = new Thread(){
				public void run(){
					int choice = 0;

					try{
						System.out.println("Enter one integer as input");
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
			//System.out.println("Starting");
			pthread.start();
			
			
			synchronized(pthread){
				pthread.wait();
			}		
			
			//System.out.println("Finished.");
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
		System.out.println("Args is " + args + "; Done.");
	}

}
