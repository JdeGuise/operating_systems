
public class CollatzCalcs {
	
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
